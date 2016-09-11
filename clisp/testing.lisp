;;; testing.lisp
;;; by Philip Fong
;;;
;;; Introductory comments are preceded by ";;;"
;;; Function headers are preceded by ";;"
;;; Inline comments are introduced by ";"
;;;

;;
;; Triple the value of a number
;;

(defun triple (X)
  "Compute three times X."  ; Inline comments can
  (* 3 X))                  ; be placed here.

;;
;; Negate the sign of a number
;;

(defun negate (X)
  "Negate the value of X."  ; This is a documentation string.
  (- X))
  
;;
;; Factorial of a Number
;;
(defun factorial (N)
  "Compute the factorial of N."
  (if (= N 1)
      1
    (* N (factorial (- N 1)))))
	
;;
;; Triangular Numbers
;;

(defun triangle (N)
  " Calculate the Triangle Number where T (n) = n + T (n -1)."
  (if
   (<= N 1)
     1
     (+ N (triangle (1- N)))      
    )
  )
  
;;
;; Fibo nacci Numbers
;;

(defun fibonacci (N)
  " Calculate the Fibo nacci Numbers where F(x) = F (x - 1) + F (x - 2). "
  (if (or (zerop N) (= N 1))
    1
    (+ (fibonacci (1- N)) (fibonacci (- N 2)) 
	)
  )
)

;;
;; End of File
;;
 