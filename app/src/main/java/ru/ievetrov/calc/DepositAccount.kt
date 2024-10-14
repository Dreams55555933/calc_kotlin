package ru.ievetrov.calc

class DepositAccount(val name:String = "Default") {
    private var availableFunds:Double = 790_000.0

    //Метод для получения доступных средств
    fun getAvaibleFounds():Double{
        return availableFunds
    }

    //Метод для снятие средств со счета
    fun withdrawMoney(amount:Double):Double{
        return if (amount > 0 && amount <= availableFunds){
            availableFunds -= amount
            amount
        }else{
            0.0
        }
    }

    //Метод для внесения данных на карту
    fun depositMoney(amount: Double){
        if (amount > 0){
            availableFunds += amount
            println("$amount рублей успешно внесено на имя $name")
        }else{
            println("Невозможно внести отрицательную сумму")
        }
    }
}