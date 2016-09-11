; Sample Adder program
(defun adder()
(terpri)(terpri)
(princ "Enter First Number to add:")
(setq num1 (read))
(princ "Enter Second Number to add:")
(setq num2 (read))
(terpri)
(princ "Sum : ")
(write (+ num1 num2))
)
(adder)

