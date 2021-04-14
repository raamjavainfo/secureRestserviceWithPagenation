create a table with name transactions in database with below columns
    id, accountNumber, trxAmount, desc, trxDate, trxTime, customerId
    
run TestDemoApplication.java to start the application in Dev system


Request with Customer Id   :    http://localhost.8080/testDemo/transactionByCustId=222?start=1?size=10
        with out pagnation  :    http://localhost.8080/testDemo/transactionByCustId=222
Request with accountnumber:     http://localhost.8080/testDemo/getTransactionByAccountNumber=8872838283?start=1?size=10
          with out pagnation:    http://localhost.8080/testDemo/getTransactionByAccountNumber=8872838283