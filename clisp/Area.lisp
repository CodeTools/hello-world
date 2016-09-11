; Area calculating program
(defvar choice 0)
(defvar area   0)
; define the Circle area Function
(defun circle()
(princ " Enter the radius of the circle.")
(setq area (read))
(setq area (* area area 0.5 3.14))
(princ (list "The area of cicle is " area))
)
; define the Triangle area Function
(defun triangle()
(princ " you want area of a Triangle." )
)
; define the Rectangle area Function 
(defun rectangle()
(princ " you want area of a Rectangle." )
)
; define the area function
(defun area()
; Print an empty line
(terpri)
; Print what the hell is this
(loop 
(terpri)
(princ "Area function 1.0")
(terpri)
(terpri)
(princ "1. Area of a circle")
(terpri)
(princ "2. Area of a Triangle")
(terpri)
(princ "3. Area of a Rectangle")
(terpri)
(princ "4. Exit")
(terpri)
(princ "Enter your choice:")
(setq choice (read))
(terpri)
(cond 
	((eq choice 1) (circle))
	((eq choice 2) (triangle))
	((eq choice 3) (rectangle))
	((eq choice 4) (return))
        ((eq choice 5) (princ "Invalid choice"))
	((eq choice 6) (princ "Invalid choice"))
	((eq choice 7) (princ "Invalid choice"))
        ((eq choice 8) (princ "Invalid choice"))
	((eq choice 9) (princ "Invalid choice"))
)
; end of loop statement
)
)
; Call the function
(area)