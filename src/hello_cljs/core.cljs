(ns hello-cljs.core
  (:require [reagent.core :as r]
            [cljsjs.react-motion]))

(enable-console-print!)

(def Motion js/ReactMotion.Motion)
(def spring js/ReactMotion.spring)

(def toggled? (r/atom false))

(defn app []
  [:div
   [:button {:on-mouse-down #(swap! toggled? not)} "Toggle"]
   ; Smiley bird :> Motion is same as using (r/adapt-react-class Motion)
   [:> Motion {:style #js {:x (spring (if @toggled? 400 0))}} ; #js == js reader tag
    (fn [style]
      (let [x (.-x style)] ; style is js-object, so easiest way to get the x property out is .-x
        (r/as-element ; Turn hiccup into a plain React element, which the Motion will then render
          [:div.slider
           [:div.slider-block
            {:style {:transform (str "translate3d(" x "px, 0, 0)")}}]])))]])

(r/render [app]
  (js/document.getElementById "app"))
