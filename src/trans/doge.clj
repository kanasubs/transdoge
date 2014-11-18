(ns trans.doge
  (:use benri.kuro)
  (:refer-clojure :exclude [update]) ; OPTIMIZE remove after upgrade to clj 1.7
  (:require [clojure.string :refer [upper-case trim]]
            [clojure.walk :refer [keywordize-keys]])
  (:import [com.memetix.mst.translate Translate]
           [com.memetix.mst.language Language]
           [com.memetix.mst MicrosoftTranslatorAPI]))

(defn set-credentials! [& {:keys [id secret]}]
  (Translate/setClientId id)
  (Translate/setClientSecret secret))

(defn ->lang-enum [lang]
  (let [language-ns-str "com.memetix.mst.language.Language"]
    (->> lang name upper-case (str language-ns-str "/") read-string eval)))

; TODO create default for :ENGLISH
(defn ->langs
  ([locale]
    (->> locale
         ->lang-enum
         Language/values
         (into {})
         (map-keys upper-case)
         keywordize-keys))
  ([] (->langs :ENGLISH)))

; TODO create README.md entry for this
(defn partition-by-service-constraints [items-list]
  (let [pred #(or
                (> (count (apply str (conj (last %1) %2))) 4375)
                (> (count (.getBytes (apply str (conj (last %1) %2)))) 4480))
        f #(if (pred %1 %2)
             (conj %1 [%2])
             (update %1 (-> %1 count dec) conj %2))]
    (reduce f [[]] items-list)))

(let [into-type #(if (string? %) % (into-array %))]
  (defn translate
    ([text to]
      (Translate/execute (into-type text) (->lang-enum to)))
    ([text from to]
      (Translate/execute (into-type text) (->lang-enum from) (->lang-enum to)))))

; OPTIMIZE maybe id and secret should be map like set-credentials!
(defn ->token! [id secret] (MicrosoftTranslatorAPI/getToken id secret))