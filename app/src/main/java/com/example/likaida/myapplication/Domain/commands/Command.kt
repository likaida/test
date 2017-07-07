package com.example.likaida.myapplication.Domain.commands

/**
 * Created by likaida on 2017/7/7.
 */
public interface Command<T> {
	fun execute(): T
}