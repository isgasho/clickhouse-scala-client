package com.crobox.clickhouse.dsl.column

import com.crobox.clickhouse.dsl.TableColumn.AnyTableColumn
import com.crobox.clickhouse.dsl.{ExpressionColumn, TableColumn}

trait EncodingFunctions { self: Magnets =>
  abstract class EncodingFunction[O](val column: AnyTableColumn) extends ExpressionColumn[O](column)

  case class Hex(col: HexCompatible[_])            extends EncodingFunction[String](col.column)
  case class Unhex(col: StringColMagnet[_])           extends EncodingFunction[String](col.column)
  case class UUIDStringToNum(col: StringColMagnet[_]) extends EncodingFunction[Long](col.column)
  case class UUIDNumToString(col: StringColMagnet[_]) extends EncodingFunction[Long](col.column)
  case class BitmaskToList(col: NumericCol[_])     extends EncodingFunction[String](col.column)
  case class BitmaskToArray(col: NumericCol[_])    extends EncodingFunction[Iterable[Long]](col.column)

  def hex(col: HexCompatible[_])               = Hex(col)
  def unhex(col: StringColMagnet[_])              = Unhex(col)
  def uUIDStringToNum(col: StringColMagnet[_])    = UUIDStringToNum(col)
  def uUIDNumToString(col: StringColMagnet[_])    = UUIDNumToString(col)
  def bitmaskToList(col: NumericCol[_])        = BitmaskToList(col)
  def bitmaskToArray(col: NumericCol[_])       = BitmaskToArray(col)
  /*
hex
unhex(str)
UUIDStringToNum(str)
UUIDNumToString(str)
bitmaskToList(num)
bitmaskToArray(num)
 */
}
