#include<iostream>
#include<conio.h>
#include<dos.h>
#include<windows.h>
#include<graphics.h>
#include<string.h>
#include<fstream>
using namespace std;

void delay(long int x)
{
    for(;x>0;x--);
}

class Items
{
public:
    char name[20];
    char id[20];
    int type;
    char description[100];
    float price;
    Items()
    {
        strcpy(name,"");
        strcpy(id,"");
        type=0;
        strcpy(description,"");
        price=0;
    }
    Items(char a[],char b[],int c,char d[],float e)
    {
        strcpy(name,a);
        strcpy(id,b);
        type=c;
        strcpy(description,d);
        price=e;
    }
    void displayItems()
    {

    }
    void readItem()
    {
        cout<<"Enter Name: ";
        cin>>name;
        cout<<"Enter Item ID: ";
        cin>>id;
        cout<<"Enter Item Types: \n1 -> Actuators.\n2 -> Microcontrollers.\n3 -> Sensors.\nEnter your Item Type: ";
        cin>>type;
        getchar();
        cout<<"Enter The Discription About The Project: ";
        cin>>description;
        cout<<"Enter The Price Of The Item: ";
        cin>>price;
    }
};


class Actuators:public Items
{
public:
    Actuators():Items(){}
    Actuators(char a[20],char b[20],int c,char d[20],float e):Items(a,b,c,d,e){}
    void displayItems()
    {
        cout<<"--------------------\n";;
        cout<<"Item Name: "<<this->name<<endl;
        cout<<"Item ID: "<<this->id<<endl;
        cout<<"Category: Actuators\n";
        cout<<"Price: "<<this->price<<endl;
        cout<<"Description Of The Product: "<<this->description<<endl;
        cout<<"--------------------\n";
    }
    void EditActuators()
    {
        int ch;
        while(1)
        {
            cout<<"Edit Name?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Name: ";
                    cin>>name;
                    break;
                }
                else
                    break; 
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit ID?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New ID: ";
                    cin>>id;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit Type?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Type: ";
                    cin>>type;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit Price?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New price: ";
                    cin>>this->price;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit Description?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Description: ";
                    cin>>description;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        cout<<"Item Details Edited Successfully.\n";
    }
};

class Microcontrollers:public Items
{
public:
    Microcontrollers():Items(){}
    Microcontrollers(char a[],char b[],int c,char d[],float e):Items(a,b,c,d,e){}
    void displayItems()
    {
        cout<<"--------------------\n";
        cout<<"Item Name: "<<name<<endl;
        cout<<"Item ID: "<<id<<endl;
        cout<<"Category: Microcontrollers\n";
        cout<<"Price: "<<this->price<<endl;
        cout<<"Description Of The Product: "<<description<<endl;
        cout<<"--------------------\n";
    }
    void EditMicrocontrollers()
    {
        int ch;
        while(1)
        {
            cout<<"Edit Name?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Name: ";
                    cin>>name;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit ID?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New ID: ";
                    cin>>id;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit Type?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Type: ";
                    cin>>type;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit Price?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Type: ";
                    cin>>this->price;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit Description?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Description: ";
                    cin>>description;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        cout<<"Item Details Edited Successfully.\n";
    }
};



class Sensors:public Items
{
public:
    Sensors():Items(){}
    Sensors(char a[],char b[],int c,char d[],float e):Items(a,b,c,d,e){}
    void displayItems()
    {
        cout<<"--------------------\n";
        cout<<"Item Name: "<<name<<endl;
        cout<<"Item ID: "<<id<<endl;
        cout<<"Category: Sensor\n";
        cout<<"Price: "<<this->price<<endl;
        cout<<"Description Of The Product: "<<description<<endl;
        cout<<"--------------------\n";
    }
    void EditSensors()
    {
        int ch;
        while(1)
        {
            cout<<"Edit Name?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Name: ";
                    cin>>name;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit ID?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New ID: ";
                    cin>>id;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit Type?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Type: ";
                    cin>>type;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit Price?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Type: ";
                    cin>>this->price;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        while(1)
        {
            cout<<"Edit Description?\nYes -> 01  No -> 02 :"<<endl;
            cin>>ch;
            if(ch==1||ch==2)
            {
                if(ch==1)
                {
                    cout<<"Enter New Description: ";
                    cin>>description;
                    break;
                }
                else
                    break;
            }
            else
            {
                cout<<"Invalid Input.\n";
            }
        }
        cout<<"Item Details Edited Successfully.\n";
    }
};

class User
{
public:
    char name[20];
    char USN[20];
    int sem;
    int branch;
    char address[20];
    long int pno;
    int Item[6];
        User()
    {
        strcpy(name,"");
        strcpy(USN,"");
        sem=0;
        branch=0;
        strcpy(address,"");
        pno=0;
        for(int i=0;i<8;i++)
            Item[i]=0;
    }
    User(char a[],char b[],int c,int d,char e[],long int f)
    {
        strcpy(name,a);
        strcpy(USN,b);
        sem=c;
        branch=d;
        strcpy(address,e);
        pno=f;
        for(int i=0;i<8;i++)
            Item[i]=0;
    }
    void readUser()
    {
        system("CLS");
        string a,b,e;
        int c,d;
        long int f;
        cout<<"\n\t\t\t\t\t WELCOME TO KLE TECH e-Mart.\n\nPlease Create Your New Account.\n";
        cout<<"Enter Name: ";
        cin>>name;
        cout<<"Enter USN: ";
        cin>>USN;
        while(1)
        {
            cout<<"Enter Semester: ";
            cin>>sem;
            if(sem>=1&&sem<=8)
                break;
            cout<<"Invalid Input.\n";
        }
        while(1)
        {
            cout<<"Enter Branch:\n1 -> Computer Science.\n2 -> Electronics And Communication.\n3 -> Mechanical Enginering.\n4 -> Automation And Robotics.\n5 -> Biotechnology.\nEnter Your choice: ";
            cin>>branch;
            if(branch>=1&&branch<=5)
            {
                break;
            }
            cout<<"Invalid input.\n";
        }
        cout<<"Enter The Mobile Number: ";
        cin>>pno;
        scanf("%*c");
        cout<<"Enter Address: ";
        cin>>address;
        scanf("%*c");
    }
    void displayUser()
    {
        int flag=0;
        cout<<"=========================\n";
        cout<<"Name: "<<name<<endl;
        cout<<"USN: "<<USN<<endl;
        cout<<"Branch: ";
        if(this->branch==1)
            cout<<"School Of Computer Science And Engineering.\n";
        else if(this->branch==2)
            cout<<"Electronics And Communication.\n";
        else if(this->branch==3)
            cout<<"School Of Mechanial Engineering.\n";
        else if(this->branch==4)
            cout<<"Automation And Robotics.\n";
        else
            cout<<"Biotechnology.\n";
        cout<<"Semester: "<<sem<<endl;
        cout<<"Address: "<<address<<endl;
        cout<<"Phone Number: "<<pno<<endl;
        for(int i=0;i<8;i++)
        {
            if(Item[i]!=0)
                flag=1;
                break;
        }
        if(flag==0)
            cout<<"The User Doesn't have Any Items To Sell.\n";
            cout<<"=========================\n";
    }
};



class Card
{
public:
    char name[20];
    long int cardno;
    long int pno;
    int cvv;
    float balance;
    int type;
    Card()
    {
        strcpy(name,"");
        cardno=0;
        pno=0;
        cvv=0;
        balance=0;
    }
    Card(char a[],long int b,long int c,int d,float e)
    {
        strcpy(name,a);
        cardno=b;
        pno=c;
        cvv=d;
        balance=e;
    }
    void displayCard()
    {

    }
};

class CreditCard:public Card
{
public:
    CreditCard():Card()
    {
        type=1;
    }
    CreditCard(char a[],long int b,long int c,int d,float e,int f):Card(a,b,c,d,e)
    {
        type=1;
    }
    void displayCard()
    {
        cout<<"Name On The Card: "<<name<<"."<<endl;
        cout<<"Card Number: "<<cardno<<"."<<endl;
        cout<<"Phone Number Of The Card Holder: "<<pno<<"."<<endl;
        cout<<"CVV : "<<cvv<<"."<<endl;
        cout<<"Balance In The Card: "<<balance<<"."<<endl;
        cout<<"Type Of The Card: Credit."<<endl;
    }
};

class DebitCard:public Card
{
public:
    DebitCard():Card()
    {
        type=2;
    }
    DebitCard(char a[],long int b,long int c,int d,float e,int f):Card(a,b,c,d,e)
    {
        type=2;
    }
    void displayCard()
    {
        cout<<"Name On The Card: "<<this->name<<"."<<endl;
        cout<<"Card Number: "<<this->cardno<<"."<<endl;
        cout<<"Phone Number Of The Card Holder: "<<this->pno<<"."<<endl;
        cout<<"CVV : "<<this->cvv<<"."<<endl;
        cout<<"Balance In The Card: "<<this->balance<<"."<<endl;
        cout<<"Type Of The Card: Debit."<<endl;
    }
};

class Admin
{
public:
    char name[20];
    char pno[11];
    int sem;
    char projects[200];
    char address[30];
    char dob[11];
    char clg[50];
    char interests[200];
    Admin()
    {
        strcpy(name,"");
        strcpy(pno,"0");
        strcpy(projects,"");
        sem=0;
        strcpy(address,"");
        strcpy(dob,"");
        strcpy(clg,"");
        strcpy(interests,"");
    }
    Admin(char a[],char b[],char c[],int d, char e[],char f[],char g[],char h[])
    {
        strcpy(name,a);
        strcpy(pno,b);
        strcpy(projects,c);
        sem=d;
        strcpy(address,e);
        strcpy(dob,f);
        strcpy(clg,g);
        strcpy(interests,h);
    }
    void displayAdmin()
    {
        char b=219;
        system("CLS");
        cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
        cout<<"\n\t\t\t\t\t";
        cout<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b;
        cout<<"\n\t\t\t\t\tName:          "<<name<<endl;
        cout<<"\t\t\t\t\tCollege Name:  "<<clg<<endl;
        cout<<"\t\t\t\t\tDate Of Birth: "<<dob<<endl;
        cout<<"\t\t\t\t\tSemester:      "<<sem<<endl;
        cout<<"\t\t\t\t\tInterested In: ";
        cout<<interests<<endl;
        cout<<"\t\t\t\t\tWorked On :    ";
        cout<<projects<<endl;
        cout<<"\t\t\t\t\t";
        cout<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b<<b;
        scanf("%*c");
        getchar();
    }
};

class MyException
{
public:
    int errnum;
    string errmsg;
    MyException()
    {
        errnum=0;
        errmsg="";
    }
    MyException(int a,string b)
    {
        errnum=a;
        errmsg=b;
    }
    void displayException()
    {
        cout<<errnum<<" : "<<errmsg<<endl;
    }
};

