; Sample minus Program
(defun minus()
	(terpri)(terpri)
	(princ "Enter Larger Number:")
	(setq large (read))
	(princ "Enter Smaller Number:")
	(setq small (read))
	(terpri)
	(if
		(< large small)
		(princ "Large is less than smaller")
		(write (- large small))
	)
	
)
(minus)