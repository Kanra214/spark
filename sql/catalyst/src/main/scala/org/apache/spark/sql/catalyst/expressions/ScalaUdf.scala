/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.catalyst.expressions

import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.types.DataType

/**
 * User-defined function.
 * @param dataType  Return type of function.
 */
case class ScalaUdf(function: AnyRef, dataType: DataType, children: Seq[Expression])
  extends Expression {

  type EvaluatedType = Any

  override def nullable: Boolean = true

  override def toString: String = s"scalaUDF(${children.mkString(",")})"

  // scalastyle:off

  /** This method has been generated by this script

    (1 to 22).map { x =>
      val anys = (1 to x).map(x => "Any").reduce(_ + ", " + _)
      val childs = (0 to x - 1).map(x => s"val child$x = children($x)").reduce(_ + "\n      " + _)
      val evals = (0 to x - 1).map(x => s"ScalaReflection.convertToScala(child$x.eval(input), child$x.dataType)").reduce(_ + ",\n          " + _)

      s"""    case $x =>
      val func = function.asInstanceOf[($anys) => Any]
      $childs
      (input: Row) => {
        func(
          $evals)
      }
      """
    }.foreach(println)

  */
  
  val f = children.size match {
    case 0 => 
      val func = function.asInstanceOf[() => Any]
      (input: Row) => {
        func()
      }
      
    case 1 =>
      val func = function.asInstanceOf[(Any) => Any]
      val child0 = children(0)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType))
      }
      
    case 2 =>
      val func = function.asInstanceOf[(Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType))
      }
      
    case 3 =>
      val func = function.asInstanceOf[(Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType))
      }
      
    case 4 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType))
      }
      
    case 5 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType))
      }
      
    case 6 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType))
      }
      
    case 7 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType))
      }
      
    case 8 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType))
      }
      
    case 9 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType))
      }
      
    case 10 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType))
      }
      
    case 11 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType))
      }
      
    case 12 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType))
      }
      
    case 13 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      val child12 = children(12)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType),
          ScalaReflection.convertToScala(child12.eval(input), child12.dataType))
      }
      
    case 14 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      val child12 = children(12)
      val child13 = children(13)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType),
          ScalaReflection.convertToScala(child12.eval(input), child12.dataType),
          ScalaReflection.convertToScala(child13.eval(input), child13.dataType))
      }
      
    case 15 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      val child12 = children(12)
      val child13 = children(13)
      val child14 = children(14)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType),
          ScalaReflection.convertToScala(child12.eval(input), child12.dataType),
          ScalaReflection.convertToScala(child13.eval(input), child13.dataType),
          ScalaReflection.convertToScala(child14.eval(input), child14.dataType))
      }
      
    case 16 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      val child12 = children(12)
      val child13 = children(13)
      val child14 = children(14)
      val child15 = children(15)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType),
          ScalaReflection.convertToScala(child12.eval(input), child12.dataType),
          ScalaReflection.convertToScala(child13.eval(input), child13.dataType),
          ScalaReflection.convertToScala(child14.eval(input), child14.dataType),
          ScalaReflection.convertToScala(child15.eval(input), child15.dataType))
      }
      
    case 17 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      val child12 = children(12)
      val child13 = children(13)
      val child14 = children(14)
      val child15 = children(15)
      val child16 = children(16)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType),
          ScalaReflection.convertToScala(child12.eval(input), child12.dataType),
          ScalaReflection.convertToScala(child13.eval(input), child13.dataType),
          ScalaReflection.convertToScala(child14.eval(input), child14.dataType),
          ScalaReflection.convertToScala(child15.eval(input), child15.dataType),
          ScalaReflection.convertToScala(child16.eval(input), child16.dataType))
      }
      
    case 18 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      val child12 = children(12)
      val child13 = children(13)
      val child14 = children(14)
      val child15 = children(15)
      val child16 = children(16)
      val child17 = children(17)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType),
          ScalaReflection.convertToScala(child12.eval(input), child12.dataType),
          ScalaReflection.convertToScala(child13.eval(input), child13.dataType),
          ScalaReflection.convertToScala(child14.eval(input), child14.dataType),
          ScalaReflection.convertToScala(child15.eval(input), child15.dataType),
          ScalaReflection.convertToScala(child16.eval(input), child16.dataType),
          ScalaReflection.convertToScala(child17.eval(input), child17.dataType))
      }
      
    case 19 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      val child12 = children(12)
      val child13 = children(13)
      val child14 = children(14)
      val child15 = children(15)
      val child16 = children(16)
      val child17 = children(17)
      val child18 = children(18)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType),
          ScalaReflection.convertToScala(child12.eval(input), child12.dataType),
          ScalaReflection.convertToScala(child13.eval(input), child13.dataType),
          ScalaReflection.convertToScala(child14.eval(input), child14.dataType),
          ScalaReflection.convertToScala(child15.eval(input), child15.dataType),
          ScalaReflection.convertToScala(child16.eval(input), child16.dataType),
          ScalaReflection.convertToScala(child17.eval(input), child17.dataType),
          ScalaReflection.convertToScala(child18.eval(input), child18.dataType))
      }
      
    case 20 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      val child12 = children(12)
      val child13 = children(13)
      val child14 = children(14)
      val child15 = children(15)
      val child16 = children(16)
      val child17 = children(17)
      val child18 = children(18)
      val child19 = children(19)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType),
          ScalaReflection.convertToScala(child12.eval(input), child12.dataType),
          ScalaReflection.convertToScala(child13.eval(input), child13.dataType),
          ScalaReflection.convertToScala(child14.eval(input), child14.dataType),
          ScalaReflection.convertToScala(child15.eval(input), child15.dataType),
          ScalaReflection.convertToScala(child16.eval(input), child16.dataType),
          ScalaReflection.convertToScala(child17.eval(input), child17.dataType),
          ScalaReflection.convertToScala(child18.eval(input), child18.dataType),
          ScalaReflection.convertToScala(child19.eval(input), child19.dataType))
      }
      
    case 21 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      val child12 = children(12)
      val child13 = children(13)
      val child14 = children(14)
      val child15 = children(15)
      val child16 = children(16)
      val child17 = children(17)
      val child18 = children(18)
      val child19 = children(19)
      val child20 = children(20)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType),
          ScalaReflection.convertToScala(child12.eval(input), child12.dataType),
          ScalaReflection.convertToScala(child13.eval(input), child13.dataType),
          ScalaReflection.convertToScala(child14.eval(input), child14.dataType),
          ScalaReflection.convertToScala(child15.eval(input), child15.dataType),
          ScalaReflection.convertToScala(child16.eval(input), child16.dataType),
          ScalaReflection.convertToScala(child17.eval(input), child17.dataType),
          ScalaReflection.convertToScala(child18.eval(input), child18.dataType),
          ScalaReflection.convertToScala(child19.eval(input), child19.dataType),
          ScalaReflection.convertToScala(child20.eval(input), child20.dataType))
      }
      
    case 22 =>
      val func = function.asInstanceOf[(Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any, Any) => Any]
      val child0 = children(0)
      val child1 = children(1)
      val child2 = children(2)
      val child3 = children(3)
      val child4 = children(4)
      val child5 = children(5)
      val child6 = children(6)
      val child7 = children(7)
      val child8 = children(8)
      val child9 = children(9)
      val child10 = children(10)
      val child11 = children(11)
      val child12 = children(12)
      val child13 = children(13)
      val child14 = children(14)
      val child15 = children(15)
      val child16 = children(16)
      val child17 = children(17)
      val child18 = children(18)
      val child19 = children(19)
      val child20 = children(20)
      val child21 = children(21)
      (input: Row) => {
        func(
          ScalaReflection.convertToScala(child0.eval(input), child0.dataType),
          ScalaReflection.convertToScala(child1.eval(input), child1.dataType),
          ScalaReflection.convertToScala(child2.eval(input), child2.dataType),
          ScalaReflection.convertToScala(child3.eval(input), child3.dataType),
          ScalaReflection.convertToScala(child4.eval(input), child4.dataType),
          ScalaReflection.convertToScala(child5.eval(input), child5.dataType),
          ScalaReflection.convertToScala(child6.eval(input), child6.dataType),
          ScalaReflection.convertToScala(child7.eval(input), child7.dataType),
          ScalaReflection.convertToScala(child8.eval(input), child8.dataType),
          ScalaReflection.convertToScala(child9.eval(input), child9.dataType),
          ScalaReflection.convertToScala(child10.eval(input), child10.dataType),
          ScalaReflection.convertToScala(child11.eval(input), child11.dataType),
          ScalaReflection.convertToScala(child12.eval(input), child12.dataType),
          ScalaReflection.convertToScala(child13.eval(input), child13.dataType),
          ScalaReflection.convertToScala(child14.eval(input), child14.dataType),
          ScalaReflection.convertToScala(child15.eval(input), child15.dataType),
          ScalaReflection.convertToScala(child16.eval(input), child16.dataType),
          ScalaReflection.convertToScala(child17.eval(input), child17.dataType),
          ScalaReflection.convertToScala(child18.eval(input), child18.dataType),
          ScalaReflection.convertToScala(child19.eval(input), child19.dataType),
          ScalaReflection.convertToScala(child20.eval(input), child20.dataType),
          ScalaReflection.convertToScala(child21.eval(input), child21.dataType))
      }
  }
  
  // scalastyle:on
  
  override def eval(input: Row): Any = ScalaReflection.convertToCatalyst(f(input), dataType)

}
