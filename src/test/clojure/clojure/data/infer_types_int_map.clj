(ns clojure.data.infer-types-int-map
  (:require [clojure.test :refer :all]
            [clojure.core.typed :as t]
            [clojure.core.typed.runtime-infer :as infer]))

(defn delete-anns [nss]
  (doseq [ns nss]
    (infer/delete-generated-annotations
      ns
      {:ns ns})))

(defn infer-anns [nss]
  (doseq [ns nss]
    (prn "infer" ns)
    (t/runtime-infer :ns ns)))

(def infer-files
  '[clojure.data.int-map
])

;; FIXME shouldn't need this, but some types
;; don't compile
(delete-anns infer-files)
(apply require (conj infer-files :reload))

(def tests 
  '[clojure.data.int-map-test
    ])

(apply require tests)
(apply run-tests tests)

(infer-anns infer-files)

