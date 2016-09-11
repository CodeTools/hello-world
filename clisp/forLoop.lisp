;Simple For Loop
(defun create-squares() 
(terpri)(terpri)
(princ "=====Collect tuples of numbers and their squares=====")
(terpri)
(princ "Enter starter:")
(setq starter (read))
(princ "Enter ender:")
(setq ender (read))
(cond
  ((< starter ender) 
	(write 
		(loop for i from starter upto ender by 1 
			for j = (* i i) 
			collect (list i j) 
                 )
         )
   ) 
  ((> starter ender) (write "Ender is less than starter")) 
  ((= starter ender) (write "Ender is equal to starter"))
  )
)
(create-squares)