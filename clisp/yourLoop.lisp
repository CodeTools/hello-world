;Load and Collect 
(defun your-loop() 
(terpri)
(princ "Enter starter:")
(setq starter (read))
(princ "Enter ender:")
(setq ender (read))
(if 
	(> ender starter) 
 		(write (loop for i from starter upto ender by 1 collect i)) 
		(princ "Ender is less than Starter.")
) 		
)
(your-loop)