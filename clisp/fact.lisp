;
; Factorial Function [ Recursive ]
;
(defun fact(N)
	(if (<= N 1) 
		1
		(* N (fact (1- N))) 
	)
	
)
;
;  Factorial Function [ Iterative ]
;
(defun factorial(N)
	(if (= N 0) (return-from factorial 0))
	(let ((x 1))
		(loop for y from 1 upto N
		  	do		
		  (setq x (* x y))	
		)
		(return-from factorial x)	
	)	
)

(terpri)
(print "Recursive Factorial")
(terpri)

(loop for x from 1 upto 10
	do
	(print (factorial x))
)

(terpri)
(print "Iterative Factorial")
(terpri)


(loop for x from 1 upto 10
	do
	(print (factorial x))
)
