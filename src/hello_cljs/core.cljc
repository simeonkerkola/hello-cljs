(ns hello-cljs.core)

(defn say-hello []
  #?(:clj (println "Hello from clojure")
     :cljs (js/console.log "Hello from clojurescript")))

(say-hello)
