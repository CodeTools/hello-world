;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; calc.lisp -- a simple stack-based calculator
;; intended for use in evolving calculator programs
;;
;; c) 1999, Lee Spector
;;
;; version 1.19990329 (n.yyyymmdd)

#|

Notes:

This is a stack-based calculator intended for use in evolving calculator
programs. It is a simplified version of a HP-style calculator.

The calculator code is generic Common Lisp, but the calculator-like 
user interface, in calc-interface.lisp, will run only in Macintosh
Common Lisp.

There are two memory registers, A & B, which should be thought of
as "read only" during calculations. The idea is that these will be set
by the calling environment before running a calculation, to provide
inputs to the calculation. 

So to run a stored/evolved calculation you'll probably want to:

(calc-clear)          ;; clear everything
(calc-set-a <number>) ;; set the A memory register if desired
(calc-set-b <number>) ;; set the B memory register if desired
<run calculator program here>
(setq MY-ANSWER (calc-answer)) ;; get answer from calc-answer


Functions that you can include in calculator programs:

CALC-CLEAR  ;; you probably don't really want to include this
CALC-0      ;; digit keys
CALC-1 
CALC-2
CALC-3
CALC-4
CALC-5
CALC-6
CALC-7
CALC-8
CALC-9
CALC-.      ;; decimal point
CALC-ENTER  ;; pushes the displayed number onto the stack
CALC-+      ;; addition
CALC--      ;; subtraction
CALC-*      ;; multiplication
CALC-/      ;; protected division, dividing by 0 yields 0
CALC-SQRT   ;; square root, takes absolute value first
CALC-CHS    ;; change sign
CALC-SQ     ;; square
CALC-X^Y    ;; X to the Y power, X is in display, Y is next on stack
CALC-ABS    ;; absolute value
CALC-PI     ;; the number pi (3.1415...)
CALC-E      ;; the number e (2.7182...)
CALC-LN     ;; natural log (base e), takes abs to avoid complex result
CALC-SIN    ;; sine, arg in radians
CALC-COS    ;; cosine, arg in radians
CALC-TAN    ;; tangent, arg in radians
CALC-1/X    ;; protected reciprocal, yields 0 if display is 0
CALC-A      ;; puts A memory register into display
CALC-B      ;; puts B memory register into display
CALC-X<->Y  ;; swaps top two elements of stack


|#

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; global variables

(defvar *calc-display-string* "" 
  "The current display as a string")

(defvar *calc-stack* nil 
  "The stack of the stack-based calculator")

(defvar *calc-result-just-displayed* nil
  "A flag to facilitate handling of a special case for the calculator state.")

(defvar *calc-enter-just-pressed* nil
  "A flag to facilitate handling of a special case for the calculator state.")

(defvar *calc-.-just-pressed* nil
  "A flag to facilitate handling of a special case for the calculator state.")

(defvar *a* 0
  "Holds the value of the A memory.")

(defvar *b* 0 
  "Holds the value of the B memory.")

(defparameter *basically-zero* 0.000000001
  "A small number, used to prevent over/underflow in certain numerical
operations. For example, if a number less than this appears as a denominator
then a special result (zero) is returned.")

(defun calc-clear ()
  "Clears the calculator's display, stack, and memory registers."
  (setq *calc-display-string* "0"
        *calc-stack* (list 0)
        *calc-result-just-displayed* nil
        *calc-enter-just-pressed* nil
        *calc-.-just-pressed* nil
        *a* 0
        *b* 0)
  (values))

(defun print-state ()
  "Prints the calculator's state to the standard output (usually
the terminal or a Listener window)."
  (format t "~%-- Calculator State --")
  (format t "~%A:~A, B:~A" *a* *b*)
  (format t "~%Stack:")
  (dolist (n *calc-stack*)
    (format t "~%~A~A" n (case n (0 " (x)") (1 " (y)") (t ""))))
  (format t "~%-- End --~%"))

(defun pop-stack ()
  "Removes and returns the number on top of the calculator stack,
or 0 if the stack is empty."
  (if (null *calc-stack*)
    0
    (let ((top (first *calc-stack*)))
      (setq *calc-stack* (rest *calc-stack*))
      top)))

(defun calc-answer ()
  "returns the number on top of the calculator stack,
or 0 if the stack is empty."
  (if (null *calc-stack*)
    0
    (first *calc-stack*)))

(defun push-stack (n)
  "Pushes n onto the calculator stack."
  (push n *calc-stack*)
  (values))

(defun stack-top->display-string ()
  "Puts a string representation of the number on top of the
stack into the display string."
  (setq *calc-display-string* 
        (format nil "~A~A" (first *calc-stack*)
                (if *calc-.-just-pressed* "." "")))
  (values))

(defun display-string->stack ()
  "Reads the display string to obtain a number which is
then pushed onto the calculator stack."
  (push-stack (read-from-string *calc-display-string*))
  (values))

(defun display-string->replace-stack-top ()
  "Reads the display string to obtain a number which is
then pushed onto the calculator stack in place of the
current stack top."
  (pop-stack)
  (push-stack (read-from-string *calc-display-string*))
  (stack-top->display-string)
  (values))

(defun handle-new-number-after-result ()
  "Handles resetting flags and registers properly after
a new result has been displayed."
  (when *calc-result-just-displayed*
    (display-string->stack)
    (setq *calc-display-string* "0")
    (setq *calc-result-just-displayed* nil))
  (when *calc-enter-just-pressed*
    (setq *calc-display-string* "0")
    (setq *calc-enter-just-pressed* nil)))

(defun digit-key (digit-string)
  "Simulates the pressing of the specified digit-string
on the calculator."
  (setq *calc-.-just-pressed* nil)
  (handle-new-number-after-result)
  (setq *calc-display-string*
        (concatenate 'string *calc-display-string* digit-string))
  (display-string->replace-stack-top))

(defun calc-0 () "Presses the 0 key" (digit-key "0"))
(defun calc-1 () "Presses the 1 key" (digit-key "1"))
(defun calc-2 () "Presses the 2 key" (digit-key "2"))
(defun calc-3 () "Presses the 3 key" (digit-key "3"))
(defun calc-4 () "Presses the 4 key" (digit-key "4"))
(defun calc-5 () "Presses the 5 key" (digit-key "5"))
(defun calc-6 () "Presses the 6 key" (digit-key "6"))
(defun calc-7 () "Presses the 7 key" (digit-key "7"))
(defun calc-8 () "Presses the 8 key" (digit-key "8"))
(defun calc-9 () "Presses the 9 key" (digit-key "9"))

(defun calc-. ()
  "Presses the decimal (.) key on the calculator."
  (handle-new-number-after-result)
  (unless (find #\. *calc-display-string*)
    (setq *calc-display-string*
          (concatenate 'string *calc-display-string* "."))
    (setq *calc-.-just-pressed* t)
    (display-string->replace-stack-top)))

(defun calc-enter ()
  "Presses the ENTER key on the calculator."
  (display-string->stack)
  (setq *calc-enter-just-pressed* t)
  (setq *calc-.-just-pressed* nil)
  (values))

(defun calc-binary-op (op)
  "A utility for specifying binary calculator operators.
Op should be a function of two numbers that returns a number."
  (let* ((second-arg (pop-stack))
         (first-arg (pop-stack))
         (result (funcall op first-arg second-arg)))
    (push-stack result)
    (setq *calc-.-just-pressed* nil)
    (stack-top->display-string)
    (setq *calc-result-just-displayed* t))
  (values))

(defun calc-unary-op (op)
  "A utility for specifying unary calculator operators.
Op should be a function of one number that returns a number."
  (let* ((arg (pop-stack))
         (result (funcall op arg)))
    (push-stack result)
    (setq *calc-.-just-pressed* nil)
    (stack-top->display-string)
    (setq *calc-result-just-displayed* t))
  (values))

(defun calc-+ ()
  "Presses the plus (+) key on the calculator."
  (calc-binary-op #'+))

(defun calc-- ()
  "Presses the minus (-) key on the calculator."
  (calc-binary-op #'-))

(defun calc-* ()
  "Presses the times (* or x) key on the calculator."
  (calc-binary-op #'*))

(defun calc-/ ()
  "Presses the protected division (/) key on the calculator."
  (calc-binary-op
   #'(lambda (num denom)
       (if (<= (abs denom) *basically-zero*)
         0
         (float (/ num denom))))))

(defun calc-sqrt ()
  "Presses the square-root key on the calculator."
  (calc-unary-op #'(lambda (n) (sqrt (abs n)))))

(defun calc-chs ()
  "Presses the change-sign key on the calculator."
  (calc-unary-op #'(lambda (n) (- n))))

(defun calc-sq ()
  "Presses the 'square' key on the calculator."
  (calc-unary-op #'(lambda (n) (* n n))))

(defun calc-x^y ()
  "Presses the x^y (raise x to the y power) key on the calculator."
  (calc-binary-op
   #'(lambda (y x)
       (if (zerop x)
         0
         (expt (abs x) (if (zerop y) 0 y))))))

(defun calc-abs ()
  "Presses the absolute value key on the calculator."
  (calc-unary-op #'abs))

(defun calc-pi ()
  "Presses the pi (3.14...) key on the calculator."
  (handle-new-number-after-result)
  (calc-unary-op #'(lambda (arg) arg pi)))

(defun calc-e ()
  "Presses the e (2.71...) key on the calculator."
  (handle-new-number-after-result)
  (calc-unary-op #'(lambda (arg) arg (exp 1))))

(defun calc-ln ()
  "Presses the natural log key on the calculator."
  (calc-unary-op 
   #'(lambda (arg)
       (if (<= (abs arg) *basically-zero*)
         0
         (log (abs arg))))))

(defun calc-sin ()
  "Presses the sine key on the calculator."
  (calc-unary-op #'sin))

(defun calc-cos ()
  "Presses the cosine key on the calculator."
  (calc-unary-op #'cos))

(defun calc-tan ()
  "Presses the tangent key on the calculator."
  (calc-unary-op #'tan))

(defun calc-1/x ()
  "Presses the 1/x (protected reciprocal) key on the calculator."
  (calc-unary-op
   #'(lambda (n) 
       (if (<= (abs n) *basically-zero*)
         0
         (float (/ 1 n))))))

(defun calc-a ()
  "Presses the memory A key on the calculator."
  (handle-new-number-after-result)
  (calc-unary-op #'(lambda (arg) arg *a*)))

(defun calc-b ()
  "Presses the memory B key on the calculator."
  (handle-new-number-after-result)
  (calc-unary-op #'(lambda (arg) arg *b*)))

(defun calc-set-a (n)
  "Sets the value of the calculator's A register to n"
  (setq *a* n)
  (values))

(defun calc-set-b (n)
  "Sets the value of the calculator's B register to n"
  (setq *b* n)
  (values))

(defun calc-x<->y ()
  "Exchanges the top two elements on the stack"
  (let ((arg1 (pop-stack))
        (arg2 (pop-stack)))
    (push-stack arg1)
    (push-stack arg2)
    (stack-top->display-string)
    (setq *calc-result-just-displayed* t))
  (values))

;; initialize
(calc-clear)

