package com.stpl.pms.javabeans;

public class WariDepositeRequest
{
    private String amount;

    private String depositMode;

    private String providerName;

    private String paymentType;

    private String refTxnNo;

    private String userName;

    private String requestType;

    private String domainName;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }

    public String getDepositMode ()
    {
        return depositMode;
    }

    public void setDepositMode (String depositMode)
    {
        this.depositMode = depositMode;
    }

    public String getProviderName ()
    {
        return providerName;
    }

    public void setProviderName (String providerName)
    {
        this.providerName = providerName;
    }

    public String getPaymentType ()
    {
        return paymentType;
    }

    public void setPaymentType (String paymentType)
    {
        this.paymentType = paymentType;
    }

    public String getRefTxnNo ()
    {
        return refTxnNo;
    }

    public void setRefTxnNo (String refTxnNo)
    {
        this.refTxnNo = refTxnNo;
    }

    public String getUserName ()
    {
        return userName;
    }

    public void setUserName (String userName)
    {
        this.userName = userName;
    }

    public String getRequestType ()
    {
        return requestType;
    }

    public void setRequestType (String requestType)
    {
        this.requestType = requestType;
    }

    public String getDomainName ()
    {
        return domainName;
    }

    public void setDomainName (String domainName)
    {
        this.domainName = domainName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [amount = "+amount+", depositMode = "+depositMode+", providerName = "+providerName+", paymentType = "+paymentType+", refTxnNo = "+refTxnNo+", userName = "+userName+", requestType = "+requestType+", domainName = "+domainName+"]";
    }
}