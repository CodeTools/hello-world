; CIRCLE Area calculating program
(defun circle()
; Print Empty Lines
(terpri)
(terpri)
; print the prompt to enter the radius
(princ "Enter radius:")
; set the value of radius
(setq radius (read))
; set the value of area
(setq area (* 3.1416 radius radius))
; print the prompt for the Area
(terpri)
(princ "Area : ")
; Write the area to the console
(write area)
; end the function
)
; call the Circle Function
(circle)