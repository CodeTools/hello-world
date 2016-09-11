(loop for x from 0 upto 10
 do (loop for y from 0 upto 10 
	do 
		(cond 
			((or (= y 0) (= x 0) (= y 10) (= x 10) ) 
                        (princ "*"))
                        (t (princ " "))                 
                )
                
    )
    (terpri)
)