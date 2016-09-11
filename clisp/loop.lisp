; Loop CLISP
; 
(
; function starts
defun loop-1()
(terpri)
; terpri or new line
(loop for i from 1 upto 5 by 1 do 
(princ "Enter Number")
; Set a variable multiplied by 10 of the number input by the user
(setq  x (* 10 (read)))
; Print X
(print x)
; set the new line
(terpri)
)
; loop ends
)
; functions ends
; main function call
(loop-1)