(defproject transdoge "0.1.2"

  :description "An automatic translation companion in Clojure that wraps microsoft-translator-java-api"

  :url "https://github.com/kanasubs/transdoge"

  :license {:name "Apache License, Version 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0"}

  :scm {:name "git"
        :url "https://github.com/kanasubs/transdoge"}

  :repl-options {:init-ns trans.doge}

  :dependencies [[org.clojure/clojure "1.7.0-alpha1"]
                 [com.memetix/microsoft-translator-java-api "0.6.2"]
                 [medley "0.5.5"]])