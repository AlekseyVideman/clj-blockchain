(ns training.blockchain
  "
  Блокчейн без валидации блоков, с бексонечными блоками.
  "
  (:require [training.block :as block]
            [training.transaction :as trx]))

(def first-transaction (trx/create [
                                    (trx/->Action "Алексей Видеман" "перевод 1.000.000.000Р на счёт Алексей Видеман")
                                    ]))

(def genesis-block (block/create 0 [first-transaction]))

(def blockchain [genesis-block])

(defn add-block
  [block]
  (def blockchain (conj blockchain block))
  )