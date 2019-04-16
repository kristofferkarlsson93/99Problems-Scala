import org.scalatest.{Matchers, WordSpec}

class PotterBookCalculatorSpec extends WordSpec with Matchers {

  "The calculators base cases" should {
    "return 8 if 1 book is bought" in {
      val calculator = new PotterBookCalculator
      calculator.calculate(Seq(PhilosophersStone)) shouldEqual 8
    }
    "return the price with 5% discount if 2 unique books are bought" in {
      val calculator = new PotterBookCalculator
      val books = Seq(PhilosophersStone, ChamberOfSecrets)
      val result = calculator.calculate(books)
      result shouldEqual 15.2
    }
    "return the price with 10% discount if 3 unique books are bought" in {
      val calculator = new PotterBookCalculator
      val books = Seq(PhilosophersStone, ChamberOfSecrets, PrisonerOfAzkaban)
      val result = calculator.calculate(books)
      result shouldEqual 21.6
    }
    "return the price with 20% discount if 4 unique books are bought" in {
      val calculator = new PotterBookCalculator
      val books = Seq(PhilosophersStone, ChamberOfSecrets, PrisonerOfAzkaban, GobletOfFire)
      val result = calculator.calculate(books)
      result shouldEqual 25.6
    }
    "return the price with 25% discount if 5 unique books are bought" in {
      val calculator = new PotterBookCalculator
      val books = Seq(
        PhilosophersStone,
        ChamberOfSecrets,
        PrisonerOfAzkaban,
        GobletOfFire,
        OrderOfThePhenix
      )
      val result = calculator.calculate(books)
      result shouldEqual 30.00
    }
  }

  "The calculators more advanced cases" should {
    "return no discount when buying 2 of the same book" in {
      val calculator = new PotterBookCalculator
      val books = Seq(PhilosophersStone, PhilosophersStone)
      val result = calculator.calculate(books)
      result shouldEqual 8
    }
  }

}
