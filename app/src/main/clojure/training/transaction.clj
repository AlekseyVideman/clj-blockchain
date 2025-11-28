(ns training.transaction)

(defrecord Action [actor action])

(defrecord ^:private Transaction [id actions])

(defn create
  "Создаёт транзакцию."
  [actions]
  {:pre [(vector? actions)
         (not-empty actions)]}
  (->Transaction (random-uuid) actions)
  )