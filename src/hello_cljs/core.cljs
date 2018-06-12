(ns hello-cljs.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(r/render [:p "hello, world!"]
          (js/document.getElementById "app"))
