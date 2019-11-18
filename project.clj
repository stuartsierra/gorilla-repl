;;;; This file is part of gorilla-repl. Copyright (C) 2014-, Jony Hudson.
;;;;
;;;; gorilla-repl is licenced to you under the MIT licence. See the file LICENCE.txt for full details.

(defproject org.clojars.stuartsierra/gorilla-repl "0.7.0"
  :description "Custom fork of Gorilla REPL from benfb/gorilla-repl"
  :url "https://github.com/stuartsierra/gorilla-repl"
  :license {:name "MIT"}
  :dependencies ^:replace [[org.clojure/clojure "1.10.1"]
                           [http-kit "2.3.0" :exclusions [ring/ring-core]]
                           [ring/ring-json "0.5.0" :exclusions [org.clojure/clojure]]
                           [cheshire "5.9.0"]
                           [compojure "1.6.1" :exclusions [ring/ring-core ring/ring-json] ]
                           [ch.qos.logback/logback-classic "1.2.3"]
                           [gorilla-renderable "2.0.0"]
                           [gorilla-plot "0.1.4" :exclusions [org.clojure/clojure]]
                           [grimradical/clj-semver "0.3.0" :exclusions [org.clojure/clojure]]
                           [cider/cider-nrepl "0.22.4" :exclusions [org.clojure/clojure]]
                           [nrepl/nrepl "0.6.0"]
                           [clojure-complete "0.2.5"]]
  :plugins [[lein-pprint "1.2.0"]
            [lein-ancient "0.6.15"]]
  :main ^:skip-aot gorilla-repl.core
  :target-path "target/%s"
  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "v"]
                  ["deploy"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]
                  ["vcs" "push"]])
