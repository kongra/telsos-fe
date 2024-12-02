(ns telsos.fe.core
  (:require
   ["react" :as React]
   ["react-dom/client" :as react-client]
   [reagent.core :as r]
   [telsos.fe.commit-hash]))

;; APP COMPONENTS
(defn- html-root []
  (println "Hello telsos.fe!")
  [:div.sample "Hello telsos.fe!"])

;; APP INSTRUMENTATION
(defn- render-root!
  [root]
  (->> [:> React/StrictMode [html-root]]
       (r/as-element)
       (.render root)))

(defonce root-atom (atom nil))

(defn after-load! []
  (render-root! @root-atom))

(defn start! []
  (->> "core"
       (js/document.getElementById)
       (react-client/createRoot)
       (reset! root-atom)
       (render-root!)))
