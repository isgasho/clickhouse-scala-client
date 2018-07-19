package com.crobox.clickhouse.dsl.language

import com.dongxiguo.fastring.Fastring.Implicits._
import com.crobox.clickhouse.dsl._

trait SplitMergeFunctionTokenizer {
  self: ClickhouseTokenizerModule =>

  def tokenizeSplitMergeFunctionn(col: SplitMergeFunction[_]): String = col match {
    case SplitByChar(sep: StringColMagnet[_], col: ArrayColMagnet[_]) =>
      fast"splitByChar(${tokenizeColumn(sep.column)},${tokenizeColumn(col.column)})"
    case SplitByString(sep: StringColMagnet[_], col: ArrayColMagnet[_]) =>
      fast"splitByString(${tokenizeColumn(sep.column)},${tokenizeColumn(col.column)})"
    case ArrayStringConcat(col: StringColMagnet[_], sep: StringColMagnet[_]) =>
      fast"arrayStringConcat(${tokenizeColumn(col.column)},${tokenizeColumn(sep.column)})"
    case AlphaTokens(col: StringColMagnet[_]) => fast"alphaTokens(${tokenizeColumn(col.column)})"
  }

}
