(defmacro eight () (+ 3 5))
(defmacro eight1 () '(+ 3 5))
(defmacro seven () '(- (eight1) 1))

(print (eight))
(print (seven))