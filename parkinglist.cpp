#include<iostream>
using namespace std;

int main()
{
	int userinp,R=0,C=0,B=0;
	int count=0;
	int amount=0;
    while(true)
{
	cout<<"PRESS 1 FOR RICKSHAW -->"<<endl;
	cout<<"PRESS 2 FOR CAR -->"<<endl;
	cout<<"PRESS 3 FOR BUS -->"<<endl;
	cout<<"PRESS 4 FOR SHOW VEHICAL -->"<<endl;
	cout<<"PRESS 5 FOR DELETE ALL RECORD'S -->"<<endl;
	cin>>userinp;
	
	if(userinp==1)
	{	
		if(count<50)
		{	
		R++;
		amount=amount+100;
		count++;
		}
		else
		{
			cout<<"PARKING FULL BECAUSE MORE THAN 50'S VEHICHAL'S."<<endl;
		}
	}
		
		else if(userinp==2)
		{
			if(count<50)
		{	
			C++;    
			amount=amount+200;
			count++;
		}
		else
		{
			cout<<"PARKING FULL BECAUSE MORE THAN 50'S VEHICHAL'S."<<endl;
		}
		}
		else if(userinp==3)
		{
			if(count<50)
		{	
			B++;
			amount=amount+300;
			count++;
		}
		else
		{
			cout<<"PARKING FULL BECAUSE MORE THAN 50'S VEHICHAL'S."<<endl;
		}
	}
			
		
		else if(userinp==4)
		{
			cout<<"<-------------------------------------------->"<<endl;
					cout<<"TOTAL NUMBER OF VEHICAL'S-->"<<count<<endl;
					cout<<"TOTAL NUMBER OF AMOUNT'S-->"<<amount<<endl;
					cout<<"TOTAL NUMBER OF RICKSHAW'S-->"<<R<<endl;
					cout<<"TOTAL NUMBER OF CAR's-->"<<C<<endl;
			         cout<<"TOTAL NUMBER OF BUS'S-->"<<B<<endl;
			cout<<"<-------------------------------------------->"<<endl;
		}
		else if(userinp==5)
		{
			cout<<"_________________________________________"<<endl;
			amount=0;
			count=0;
			cout<<"TOTAL NUMBER OF AMOUNT'S-->"<<amount<<endl;
			cout<<"TOTAL NUMBER OF VEHICAL'S-->"<<count<<endl;
			cout<<"_________________________________________"<<endl;
		}
		else
		{
			cout<<"INVALID NUMBER"<<endl;
		}
		
	}
	
	return 0;

}