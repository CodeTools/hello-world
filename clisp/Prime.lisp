;
; Check and returns whether or not there is a factor for a number if there is returns false else true
;
(defun primep (number)
  (when (> number 1)
	(loop for factor from 2 upto (isqrt number) never (zerop (mod number factor))
	)
	)
)


;
; Loops for the Primes till upto 100
;
(loop for n from 1 upto 100 when (primep n) collect n into my-list finally (print my-list))
