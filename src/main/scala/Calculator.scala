import scala.util.control.Breaks.{break, breakable}

/** Software implementation of PROC (PROstoy Calculator) mk. 1 (or mk. 2). */

object Calculator {

	def calculate(commands: String*): Int = {

		/** Representation of `acc` register. */
		var a: Int = 0
		var b: Int = 0
		var acc: Int = 0
		var blink: Boolean = false

		/** Converts given string `s` to integer.
		 *
		 * Throws [[NumberFormatException]] if `s` can't be converted to integer,
		 * but you shouldn't worry about it at this moment.
		 */
		def parseInt(s: String): Int = s.toInt

		def isNumeric(s: String): Boolean = scala.util.Try(s.toDouble).isSuccess

		def reset(): Unit = {
			a = 0
			b = 0
			acc = 0
			blink = false
		}

		def swap(): Unit = {
			val tmp: Int = a
			a = b
			b = tmp
		}

		def blink_(): Unit = {
			blink = !blink
		}


		def parseCommand(s: String): Unit = {

			s match {
				case "+" => acc = a + b; blink = false
				case "-" => acc = a - b; blink = false
				case "*" => acc = a * b; blink = false
				case "/" => if (b == 0) reset() else acc = a / b; blink = false
				case "acc" => if (blink) b = acc else a = acc; blink_()
				case "blink" => blink_()
				case "swap" => swap()
				case "break" => break()
				case x if isNumeric(x) => val num = parseInt(x)
					if (blink) b = num else a = num
					blink_();
			}
		}

		breakable {
			for (c <- commands) {
				parseCommand(c)
			}
		}
		acc
	}
}
