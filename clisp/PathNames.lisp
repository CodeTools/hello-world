(describe (pathname "E:\\myfiles\\short_programs\\clisp\\PathNames.lisp"))
(print (directory "E:\\myfiles\\short_programs\\clisp\\*.lisp"))
(terpri)
(let ((in (open "E:\\myfiles\\short_programs\\clisp\\MyFile.lisp" :if-does-not-exist nil)))
  (when in
    (loop for line = (read-line in nil)
         while line do (format t "~a~%" line))
    (close in)))
(with-open-file (stream "E:\\myfiles\\short_programs\\clisp\\MyFile.lisp")
  (print (setq slist (read stream)))  
)