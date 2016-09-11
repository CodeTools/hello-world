(loop for x from 4 upto 10
 do (loop for y from 0 upto 20 
	do 
		(cond 
			((and (= y 10) (= x 5)) (princ "*")) 
                        ((and (or (= y 8) (= y 12)) (= x 6)) (princ "*")) 
                        ((and (or (= y 6) (= y 14)) (= x 7)) (princ "*")) 
                        ((and (or (= y 4) (= y 15)) (= x 8)) (princ "*"))                     
                        ((and (= x 9) (> y 2) (< y 17)) (princ "*"))
                        (t (princ " "))                 
                )
                
    )
    (terpri)
)