(defproject juxt-test "1.0.0"
  :description "This is a programming exercise for Juxt"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [clj-http "3.10.1"]
                 [cheshire "5.10.0"]]
  :main ^:skip-aot juxt-test.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
