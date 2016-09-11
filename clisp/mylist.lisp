; Sample My List Program
(defun build-list()
(terpri)
(let* ((list (cons 0 nil))
     (tail list))
    (loop for n from 1 below count
       do (progn
        (setf (cdr tail) (cons n nil))
        (setf tail (cdr tail))
        (format t "With n == ~d, the list is ~a~%" n list)))
    list)
)
(build-list)