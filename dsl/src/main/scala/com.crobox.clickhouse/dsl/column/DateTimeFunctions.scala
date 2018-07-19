package com.crobox.clickhouse.dsl.column

import com.crobox.clickhouse.dsl._
import org.joda.time.{DateTime, LocalDate}

trait DateTimeFunctions { self: Magnets =>
  sealed trait DateTimeFunction

  abstract class DateTimeFunctionCol[V](val ddt: DateOrDateTime[_])
      extends ExpressionColumn(ddt.column)
      with DateTimeFunction

  abstract class DateTimeConst[V]() extends ExpressionColumn[V](EmptyColumn()) with DateTimeFunction

  case class Year(d: DateOrDateTime[_])                     extends DateTimeFunctionCol[Int](d)
  case class YYYYMM(d: DateOrDateTime[_])                   extends DateTimeFunctionCol[String](d)
  case class Month(d: DateOrDateTime[_])                    extends DateTimeFunctionCol[Int](d)
  case class DayOfMonth(d: DateOrDateTime[_])               extends DateTimeFunctionCol[Int](d)
  case class DayOfWeek(d: DateOrDateTime[_])                extends DateTimeFunctionCol[Int](d)
  case class Hour(d: DateOrDateTime[_])                     extends DateTimeFunctionCol[Int](d)
  case class Minute(d: DateOrDateTime[_])                   extends DateTimeFunctionCol[Int](d)
  case class Second(d: DateOrDateTime[_])                   extends DateTimeFunctionCol[Int](d)
  case class Monday[V](d: DateOrDateTime[_])                extends DateTimeFunctionCol[V](d)
  case class StartOfMonth[V](d: DateOrDateTime[_])          extends DateTimeFunctionCol[V](d)
  case class StartOfQuarter[V](d: DateOrDateTime[_])           extends DateTimeFunctionCol[V](d)
  case class StartOfYear[V](d: DateOrDateTime[_])              extends DateTimeFunctionCol[V](d)
  case class StartOfMinute[V](d: DateOrDateTime[_])            extends DateTimeFunctionCol[V](d)
  case class StartOfFiveMinute[V](d: DateOrDateTime[_])        extends DateTimeFunctionCol[V](d)
  case class StartOfFifteenMinutes[V](d: DateOrDateTime[_])    extends DateTimeFunctionCol[V](d)
  case class StartOfHour[V](d: DateOrDateTime[_])              extends DateTimeFunctionCol[V](d)
  case class StartOfDay[V](d: DateOrDateTime[_])               extends DateTimeFunctionCol[V](d)
  case class Time(d: DateOrDateTime[_])                        extends DateTimeFunctionCol[DateTime](d)
  case class RelativeYearNum[V](d: DateOrDateTime[_])          extends DateTimeFunctionCol[V](d)
  case class RelativeMonthNum[V](d: DateOrDateTime[_])         extends DateTimeFunctionCol[V](d)
  case class RelativeWeekNum[V](d: DateOrDateTime[_])          extends DateTimeFunctionCol[V](d)
  case class RelativeDayNum[V](d: DateOrDateTime[_])           extends DateTimeFunctionCol[V](d)
  case class RelativeHourNum[V](d: DateOrDateTime[_])          extends DateTimeFunctionCol[V](d)
  case class RelativeMinuteNum[V](d: DateOrDateTime[_])        extends DateTimeFunctionCol[V](d)
  case class RelativeSecondNum[V](d: DateOrDateTime[_])        extends DateTimeFunctionCol[V](d)
  case class Now()                                       extends DateTimeConst[DateTime]()
  case class Today()                                     extends DateTimeConst[LocalDate]()
  case class Yesterday()                                 extends DateTimeConst[LocalDate]()
  case class TimeSlot(d: DateOrDateTime[_])                 extends DateTimeFunctionCol[DateTime](d)
  case class TimeSlots(d: DateOrDateTime[_], duration: NumericCol[_]) extends DateTimeFunctionCol[DateTime](d)

  //trait DateTimeFunctionsDsl {
  def toYear(col: DateOrDateTime[_])                   = Year(col)
  def toYYYYMM(col: DateOrDateTime[_])                 = YYYYMM(col)
  def toMonth(col: DateOrDateTime[_])                  = Month(col)
  def toDayOfMonth(col: DateOrDateTime[_])             = DayOfMonth(col)
  def toDayOfWeek(col: DateOrDateTime[_])              = DayOfWeek(col)
  def toHour(col: DateOrDateTime[_])                   = Hour(col)
  def toMinute(col: DateOrDateTime[_])                 = Minute(col)
  def toSecond(col: DateOrDateTime[_])                 = Second(col)
  def toMonday[T](col: DateOrDateTime[T])                 = Monday[T](col)
  def toStartOfMonth[T](col: DateOrDateTime[T])           = StartOfMonth[T](col)
  def toStartOfQuarter[T](col: DateOrDateTime[T])         = StartOfQuarter[T](col)
  def toStartOfYear[T](col: DateOrDateTime[T])            = StartOfYear[T](col)
  def toStartOfMinute[T](col: DateOrDateTime[T])          = StartOfMinute[T](col)
  def toStartOfFiveMinute[T](col: DateOrDateTime[T])      = StartOfFiveMinute[T](col)
  def toStartOfFifteenMinutes[T](col: DateOrDateTime[T])  = StartOfFifteenMinutes[T](col)
  def toStartOfHour[T](col: DateOrDateTime[T])            = StartOfHour[T](col)
  def toStartOfDay[T](col: DateOrDateTime[T])             = StartOfDay[T](col)
  def toTime(col: DateOrDateTime[_])                      = Time(col)
  def toRelativeYearNum[T](col: DateOrDateTime[T])        = RelativeYearNum[T](col)
  def toRelativeMonthNum[T](col: DateOrDateTime[T])       = RelativeMonthNum[T](col)
  def toRelativeWeekNum[T](col: DateOrDateTime[T])        = RelativeWeekNum[T](col)
  def toRelativeDayNum[T](col: DateOrDateTime[T])         = RelativeDayNum[T](col)
  def toRelativeHourNum[T](col: DateOrDateTime[T])        = RelativeHourNum[T](col)
  def toRelativeMinuteNum[T](col: DateOrDateTime[T])      = RelativeMinuteNum[T](col)
  def toRelativeSecondNum[T](col: DateOrDateTime[T])      = RelativeSecondNum[T](col)
  def chNow()                                             = Now()
  def chYesterday()                                       = Yesterday()
  def chToday()                                           = Today()

  def timeSlot(col: DateOrDateTime[_])                 = TimeSlot(col)
  def timeSlots(col: DateOrDateTime[_], duration: NumericCol[_]) = TimeSlots(col, duration)
  //}
}
