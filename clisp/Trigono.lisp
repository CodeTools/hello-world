; Trigono metric functions Lisp
(loop for x from 0 upto 90 by 10 do
	(print 
		(list
		x
		(sin x)
		(cos x)
		(tan x)
		)
	)
)