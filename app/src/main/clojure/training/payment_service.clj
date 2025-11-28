(ns training.payment-service
  "...где-то в Видеман.Пэй"
  (:require [training.block :as block]
            [training.blockchain :as chain]
            [training.transaction :as trx]))

(defn transfer
  "Переводит деньги с счета sender на счёт receiver, фиксируя транзакцию в блокчейне."
  [sender amount receiver]

  (println (format "Transferring %s money from %s to %s" amount sender receiver))

  (let [transaction (trx/create [(trx/->Action sender
                                               (format "перевод %s на счёт %s" amount receiver))])
        previous-block (last chain/blockchain)
        previous-hash (:hash previous-block)
        new-block (block/create previous-hash [transaction])]
    (chain/add-block new-block))
  )
