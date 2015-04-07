(ns trans.doge
  (:use medley.core)
  (:require [clojure.string :refer [upper-case trim]]
            [clojure.walk :refer [keywordize-keys]])
  (:import [com.memetix.mst.translate Translate]
           [com.memetix.mst.language Language]
           [com.memetix.mst MicrosoftTranslatorAPI]
           [com.memetix.mst.detect Detect]))

(defn set-credentials! [& {:keys [id secret]}]
  (Translate/setClientId id)
  (Translate/setClientSecret secret))

(defn ->lang-enum [lang]
  ":ENGLISH → com.memetix.mst.language.Language/ENGLISH → #<Language en>"
  (let [language-ns-str "com.memetix.mst.language.Language"]
    (->> lang name upper-case (str language-ns-str "/") read-string eval)))

(defn ->langs
  ([locale]
    (->> locale
         ->lang-enum
         Language/values
         (into {})
         (map-keys upper-case)
         keywordize-keys))
  ([] (->langs :ENGLISH)))

(defn detect-lang [s] (Detect/execute s))

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

