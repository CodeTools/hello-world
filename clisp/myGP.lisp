(defun fred4 (a b)
    (let ((x a))
        (loop while (<= x b) do
            (write x) (terpri)
            (setq x (* x 2))
        )
    )
)
(fred4 1 100)
