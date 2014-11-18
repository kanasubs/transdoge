(defproject transdoge "0.1.1"

  :description "An automatic translation companion in Clojure that wraps microsoft-translator-java-api"

  :url "https://github.com/ccfontes/transdoge"

  :license {:name "Apache License, Version 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"}

  :repl-options {:init-ns trans.doge}

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [com.memetix/microsoft-translator-java-api "0.6.2"]
                 [benrikuro "0.4.2"]])