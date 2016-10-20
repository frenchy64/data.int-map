(defproject org.clojure/data.int-map "0.2.2-SNAPSHOT"
  :description "Set and map data structures optimized for integer keys and elements."
  :url "https://github.com/clojure/data.int-map"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :dependencies []
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.9.0-alpha13"]
                                  [collection-check "0.1.6"]
                                  [criterium "0.4.3"]
                                  [rhizome "0.2.6"]
                                  [org.clojure/core.typed "0.3.29-SNAPSHOT"]]
                   :repl-options {:timeout 3000000}
                   :injections [(require 'clojure.core.typed)
                                (clojure.core.typed/install
                                  #{:load})]}}
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"}
  :test-selectors {:default (complement :benchmark)
                   :benchmark :benchmark}
  :java-source-paths ["src/main/java"]
  :jvm-opts ^:replace ["-server" "-Xmx10g" "-XX:-OmitStackTraceInFastThrow" "-Xss750k"]
  :global-vars {*warn-on-reflection* true})
