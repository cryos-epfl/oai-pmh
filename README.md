# OAI-PMH data provider generic implementation

This is a "lightweight" Spring based implementation of [The Open Archives Initiative Protocol for Metadata Harvesting](https://www.openarchives.org/OAI/openarchivesprotocol.html). 

## What you’ll need

* JDK 1.7 or later
* Maven 3.0+

## How to install and run demo
Download and unzip the source repository for this guide, or clone it using Git:
```
git clone https://github.com/cryos-epfl/oai-pmh.git
```

cd into ```oai-pmh/scripts ```

run ```./run_oai_pmh.sh ```

Now that the service is up, visit [http://localhost:8095/oai?verb=ListIdentifiers&metadataPrefix=dif](http://localhost:8095/oai?verb=ListIdentifiers&metadataPrefix=dif), where you see:
```
<?xml version='1.0' encoding='UTF-8'?>
<OAI-PMH xmlns='http://www.openarchives.org/OAI/2.0/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'
         xsi:schemaLocation='http://www.openarchives.org/OAI/2.0/ http://www.openarchives.org/OAI/2.0/OAI-PMH.xsd'>
    <responseDate>2015-11-05T13:52:46</responseDate>
    <request verb="ListIdentifiers">http://localhost:8095/oai</request>
<ListIdentifiers>
    <header >
    <identifier>record1</identifier>
    <datestamp>2015-11-05T13:52:46</datestamp>
</header>

</ListIdentifiers>
</OAI-PMH>
```
There is only one record in the demo application ```record1 ```. 
Now you can test various ["verbs"](https://www.openarchives.org/OAI/openarchivesprotocol.html#ProtocolMessages) of OAI-PMH. 

## Integrating your backend


