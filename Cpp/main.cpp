#include "mainmart.h"


int main()
{
    DebitCard d("Akshay",9876,7411,320,1000,2);
    Admin Akshay("Akshaykumar Gunari","7411680079","Medication Application,Music Player Application",4,"Hubli,India","18-08-1999","KLE Technological University Hubli","Android Development, Data Structures And Algorithms");
    Admin Gaurav("Gaurav J","8792860023","Medication Application,Music Player Application",4,"Hubli,India","13-09-1999","KLE Technological University Hubli","Android Development, Data Structures And Algorithms");
    char ip1,loading=219;
    int ch1,ch2,ch3,ch4,ch5,ch6,ch7,filesize,n,i,flag=0,type,modeOfPayment,Cvv;
    long int no,cardNo;
    string password,admin_password="kletech",name,id,item_id,cardName;
    fstream items,users,cards;
    ifstream f;
    Items it;
    Actuators A[1000];
    Microcontrollers M[1000];
    Sensors S[1000];
    User U[1000],u;
    Card C[100];
    cout<<"\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\tWELCOME  TO  KLE  TECH  e-MART.";
    cout<<"\n\n\n\n\n\t\t\t\t\t\tPress 'Enter' To Continue.";
    scanf("%c",&ip1);
    if(ip1=='\n')
    {
        delay(200);
        system("color 0e");
        system("CLS");
        cout<<"\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t    LOADING";
        cout<<"\n\n\t\t\t\t";
        for(int i=0;i<=50;i++)
        {
            cout<<loading;
            delay(75);
        }
        cout<<"\n\n\t\t\t\t\t\tLoading Completed.\n\n";
        delay(1000);
        system("CLS");
        system("color 0F");
        cout<<"\n\t\t\t\t\t     Welcome To KLE TECH e-Mart.\n";
        delay(1500);
        while(1)
        {
            system("CLS");
            cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
            cout<<"\n\t\tAre you\n\t\t1-> Administration Mode.\n\t\t2-> User Mode.\n\t\t3-> Exit Application.\n\t\tEnter your choice: ";
            cin>>ch1;
            if(ch1==1)
            {
                system("CLS");
                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                cout<<"\n\t\t\t\t\t     Hello Admin!\n\t\t\t\t\t     Please Enter The Admin Password: ";
                for(int j=0;j<10;j++)
                {
                    password[j]=_getch();
                    _putch('*');
                    if(password[j]==13)
                        break;
                }
                int flag=0;
                for(int j=0;j<7;j++)
                {
                    if(password[j]!=admin_password[j])
                        flag=1;
                }
                if(flag==0)
                {
                    system("CLS");
                    cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                    cout<<"\n\n\n\n\n\n\t\t\t\t\t     Welcome Admin.\n\n\t\t\t\t\t     Here Are Your Pending Tasks.";
                    delay(3000);
                    while(1)
                    {
                        system("CLS");
                        cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                        cout<<"\n\t\t\t\t\t1 -> View All The Users\n\t\t\t\t\t2 -> View All The Items.\n\t\t\t\t\t3 -> About Application Developers.\n\t\t\t\t\t4 -> Go Back.\n\t\t\t\t\tEnter Your Choice: ";
                        cin>>ch2;
                        if(ch2==1)
                        {
                            system("CLS");
                            cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                            users.open("Users.txt",ios::app);
                            cout<<"Size of Users Class: "<<sizeof(User)<<endl;
                            users.seekg(0,ios_base::end);
                            filesize=users.tellg();
                            //cout<<"Size Of Users.txt: "<<filesize<<endl;
                            n=filesize/sizeof(User);
                            cout<<"Number Of Users Present: "<<n<<endl;
                            users.close();
                            users.open("Users.txt",ios::in|ios::binary);
                            //users.seekg(0,ios_base::beg);
                            for(int i=0;i<n;i++)
                            {
                                users.read((char*)&U[i],sizeof(User));
                                U[i].displayUser();
                            }
                            users.close();
                            cout<<"Press Any Key.";
                            scanf("%*c");
                            getchar();
                        }
                        else if(ch2==2)
                        {
                            system("CLS");
                            cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                            cout<<"\n\t\t\t\t\t1 -> Actuators.\n\t\t\t\t\t2 -> Microcontrollers.\n\t\t\t\t\t3 -> Sensors.\n\t\t\t\t\t4 -> Display All Items.\n\t\t\t\t\t5 -> Exit.\n\t\t\t\t\tEnter Your Choice: ";
                            cin>>ch3;
                            if(ch3==1)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Actuators.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Actuators.txt",ios::in);
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&A[i],sizeof(Items));
                                    A[i].displayItems();
                                }
                                items.close();
                                cout<<"Press Any Key.";
                                scanf("%*c");
                                getchar();
                            }
                            else if(ch3==2)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Microcontrollers.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                               // cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Microcontrollers.txt",ios::in);
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&M[i],sizeof(Items));
                                    M[i].displayItems();
                                }
                                items.close();
                                cout<<"Press Any Key.";
                                scanf("%*c");
                                getchar();
                            }
                            else if(ch3==3)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Sensors.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Sensors.txt",ios::in);
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&A[i],sizeof(Items));
                                    A[i].displayItems();
                                }
                                items.close();
                                cout<<"Press Any Key.";
                                scanf("%*c");
                                getchar();
                            }
                            else if(ch3==4)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Actuators.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Actuators.txt",ios::in);
                                cout<<"==========     Actuators     ==========\n";
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&A[i],sizeof(Items));
                                    A[i].displayItems();
                                }
                                cout<<"=============================================\n";
                                items.close();
                                items.open("Microcontrollers.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Microcontrollers.txt",ios::in);
                                cout<<"==========     Microcontrollers     ==========\n";
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&M[i],sizeof(Items));
                                    M[i].displayItems();
                                }
                                cout<<"=============================================\n";
                                items.close();
                                items.open("Sensors.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Sensors.txt",ios::in);
                                cout<<"==========     sensors     ==========\n";
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&S[i],sizeof(Items));
                                    S[i].displayItems();
                                }
                                cout<<"=============================================\n";
                                items.close();
                                scanf("%*c");
                                getchar();
                            }
                            else if(ch3==5)
                            {
                                 break;
                            }
                            else
                            {
                                cout<<"Invalid Input.\n Please Try Again.\n";
                            }
                    }
                    else if(ch2==3)
                    {
                        //Authors profile
                        Akshay.displayAdmin();
                        Gaurav.displayAdmin();
                        scanf("%*c");
                        getchar();
                    }
                    else if(ch2==4)
                    {
                        break;
                    }
                    else
                    {
                        system("CLS");
                        cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                        cout<<"Invalid Option.\nPlease Try Again";
                        delay(2000);
                    }

                    }
                }

            }
            else if(ch1==2)
            {
                system("CLS");
                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                cout<<"\n\t\t\t\t\t1 ->New User.\n\t\t\t\t\t2 ->Existing User..\n\t\t\t\t\t3 -> Go Back.\n\t\t\t\t\tEnter Your Choice: ";
                cin>>ch4;
                if(ch4==1)
                {
                    u.readUser();
                    users.open("Users.txt",ios::app);
                    users.write((char*)&u,sizeof(User));
                    users.close();
                    cout<<"New User Added Succcessfully.\nPress Any Key to Go Back.";
                    scanf("%*c");
                    getchar();
                }
                else if(ch4==2)
                {
                    system("CLS");
                    cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                    users.open("Users.txt",ios::app);
                    cout<<"Size of Users Class: "<<sizeof(User)<<endl;
                    users.seekg(0,ios_base::end);
                    filesize=users.tellg();
                    //cout<<"Size Of Users.txt: "<<filesize<<endl;
                    n=filesize/sizeof(User);
                    cout<<"Number Of Users Present: "<<n<<endl;
                    users.close();
                    users.open("Users.txt",ios::in);
                    for(int i=0;i<n;i++)
                    {
                        users.read((char*)&U[i],sizeof(User));
                    }
                    users.close();
                    cout<<"Enter Name: ";
                    cin>>name;
                    cout<<"Enter User ID: ";
                    cin>>id;
                    flag=0;
                    for(i=0;i<n;i++)
                    {
                        if(U[i].name==name&&U[i].USN==id)
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==1)
                    {
                        cout<<"User Found.\n";
                        scanf("%*c");
                        getchar();
                        while(1)
                        {
                        system("CLS");
                        cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                        cout<<"\n\t\t\t\t\t1 -> Display Items.\n\t\t\t\t\t2 -> Display Other Users.\n\t\t\t\t\t3 -> Buy Item.\n\t\t\t\t\t4 ->Add Item.\n\t\t\t\t\t5 ->About Application Developers.\n\t\t\t\t\t6 -> Go Back.";
                        cin>>ch5;
                        if(ch5==1)
                        {
                            system("CLS");
                            cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                            cout<<"\n\t\t\t\t\t1 -> Actuators.\n\t\t\t\t\t2 -> Microcontrollers.\n\t\t\t\t\t3 -> Sensors.\n\t\t\t\t\t4 -> Display All Items.\n\t\t\t\t\t5 -> Exit.\n\t\t\t\t\tEnter Your Choice: ";
                            cin>>ch6;
                            if(ch6==1)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Actuators.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Actuators.txt",ios::in);
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&A[i],sizeof(Items));
                                    A[i].displayItems();
                                }
                                items.close();
                                cout<<"Press Any Key.";
                                scanf("%*c");
                                getchar();
                            }
                            else if(ch6==2)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Microcontrollers.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Microcontrollers.txt",ios::in);
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&M[i],sizeof(Items));
                                    M[i].displayItems();
                                }
                                items.close();
                                cout<<"Press Any Key.";
                                scanf("%*c");
                                getchar();
                            }
                            else if(ch6==3)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Sensors.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Sensors.txt",ios::in);
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&A[i],sizeof(Items));
                                    A[i].displayItems();
                                }
                                items.close();
                                cout<<"Press Any Key.";
                                scanf("%*c");
                                getchar();
                            }
                            else if(ch6==4)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Actuators.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Actuators.txt",ios::in);
                                cout<<"==========     Actuators     ==========\n";
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&A[i],sizeof(Items));
                                    A[i].displayItems();
                                }
                                cout<<"=============================================\n";
                                items.close();
                                items.open("Microcontrollers.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Microcontrollers.txt",ios::in);
                                cout<<"==========     Microcontrollers     ==========\n";
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&M[i],sizeof(Items));
                                    M[i].displayItems();
                                }
                                cout<<"=============================================\n";
                                items.close();
                                items.open("Sensors.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Sensors.txt",ios::in);
                                cout<<"==========     sensors     ==========\n";
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&S[i],sizeof(Items));
                                    S[i].displayItems();
                                }
                                cout<<"=============================================\n";
                                items.close();
                                scanf("%*c");
                                getchar();
                            }
                            else if(ch6==5)
                            {
                                 break;
                            }
                            else
                            {
                                cout<<"Invalid Input.\n Please Try Again.\n";
                            }
                        }
                        else if(ch5==2)
                        {
                            system("CLS");
                            cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                            users.open("Users.txt",ios::app);
                            cout<<"Size of Users Class: "<<sizeof(User)<<endl;
                            users.seekg(0,ios_base::end);
                            filesize=users.tellg();
                            //cout<<"Size Of Users.txt: "<<filesize<<endl;
                            n=filesize/sizeof(User);
                            cout<<"Number Of Users Present: "<<n<<endl;
                            users.close();
                            users.open("Users.txt",ios::in|ios::binary);
                            //users.seekg(0,ios_base::beg);
                            for(int i=0;i<n;i++)
                            {
                                users.read((char*)&U[i],sizeof(User));
                                U[i].displayUser();
                            }
                            users.close();
                            cout<<"Press Any Key.";
                            scanf("%*c");
                            getchar();
                        }
                        else if(ch5==3)
                        {
                            system("CLS");
                            cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                            cout<<"Type Of Items Present:\n1 -> Actuators.\n2 -> Microcontrollers.\n3 -> Sensors.\nEnter The Type Of Item You Want To Buy:" ;
                            cin>>type;
                            if(type==1)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Actuators.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Actuators.txt",ios::in);
                                int j=0;
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&A[i],sizeof(Items));
                                    j++;
                                    A[i].displayItems();
                                }
                                if(j==0)
                                {
                                    cout<<"No Actuators Present.\n";
                                }
                                else
                                {
                                    cout<<"Enter The ID Of The Product You want To Buy: ";
                                    cin>>item_id;
                                    for(int i=0;i<n;i++)
                                    {
                                        if(item_id==A[i].id)
                                        {
                                            system("CLS");
                                            cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                            cout<<"The Description Of the Product You Want To Buy: \n";
                                            A[i].displayItems();
                                            cout<<"Mode Of Payment: \n1 -> Debit Card.\n2 -> Credit Card.\n Enter your Choice: ";
                                            cin>>modeOfPayment;
                                            if(modeOfPayment==1)
                                            {
                                                cards.open("Debit.txt",ios::in);
                                                items.seekg(0,ios_base::end);
                                                int fs=items.tellg();
                                                int nd=fs/sizeof(DebitCard);
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cards.read((char*)&C[i],sizeof(DebitCard));
                                                }
                                                cout<<"Enter Name:";
                                                cin>>cardName;
                                                cout<<"Enter Card No: ";
                                                cin>>cardNo;
                                                cout<<"Enter Phone No: ";
                                                cin>>no;
                                                cout<<"Enter CVV: ";
                                                cin>>Cvv;
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cout<<"Transacting From Your Debit Card.Please Wait...\n";
                                                        for(int i=0;i<50;i++)
                                                        {
                                                            cout<<loading;
                                                            delay(150);
                                                        }
                                                        cout<<"\nYou Purchased An Item Successfully.\n";
                                                        break;

                                                }
                                            }
                                            else if(modeOfPayment==2)
                                            {
                                                cards.open("Credit.txt",ios::in);
                                                items.seekg(0,ios_base::end);
                                                int fs=items.tellg();
                                                int nd=fs/sizeof(DebitCard);
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cards.read((char*)&C[i],sizeof(DebitCard));
                                                }
                                                cout<<"Enter Name:";
                                                cin>>cardName;
                                                cout<<"Enter Card No: ";
                                                cin>>cardNo;
                                                cout<<"Enter Phone No: ";
                                                cin>>no;
                                                cout<<"Enter CVV: ";
                                                cin>>Cvv;
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cout<<"Transacting From Your Debit Card.Please Wait...\n";
                                                        for(int i=0;i<50;i++)
                                                        {
                                                            cout<<loading;
                                                            delay(150);
                                                        }
                                                        cout<<"\nYou Purchased An Item Successfully.\n";
                                                        break;

                                                }
                                            }
                                            else
                                                {
                                                    break;
                                                }
                                        }
                                    }
                                }
                                items.close();
                                cout<<"Press Any Key.";
                                scanf("%*c");
                                getchar();

                            }
                            else if(type==2)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Microcontrollers.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Microcontrollers.txt",ios::in);
                                int j=0;
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&M[i],sizeof(Items));
                                    j++;
                                    M[i].displayItems();
                                }
                                if(j==0)
                                {
                                    cout<<"No Actuators Present.\n";
                                }
                                else
                                {
                                    cout<<"Enter The ID Of The Product You want To Buy: ";
                                    cin>>item_id;
                                    for(int i=0;i<n;i++)
                                    {
                                        if(item_id==M[i].id)
                                        {
                                            system("CLS");
                                            cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                            cout<<"The Description Of the Product You Want To Buy: \n";
                                            M[i].displayItems();
                                            cout<<"Mode Of Payment: \n1 -> Debit Card.\n2 -> Credit Card.\n Enter your Choice: ";
                                            cin>>modeOfPayment;
                                            if(modeOfPayment==1)
                                            {
                                                cards.open("Debit.txt",ios::in);
                                                items.seekg(0,ios_base::end);
                                                int fs=items.tellg();
                                                int nd=fs/sizeof(DebitCard);
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cards.read((char*)&C[i],sizeof(DebitCard));
                                                }
                                                cout<<"Enter Name:";
                                                cin>>cardName;
                                                cout<<"Enter Card No: ";
                                                cin>>cardNo;
                                                cout<<"Enter Phone No: ";
                                                cin>>no;
                                                cout<<"Enter CVV: ";
                                                cin>>Cvv;
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cout<<"Transacting From Your Debit Card.Please Wait...\n";
                                                        for(int i=0;i<50;i++)
                                                        {
                                                            cout<<loading;
                                                            delay(150);
                                                        }
                                                        cout<<"\n\nYou Purchased An Item Successfully.\n";
                                                        break;

                                                }
                                            }
                                            else if(modeOfPayment==2)
                                            {
                                                cards.open("Credit.txt",ios::in);
                                                items.seekg(0,ios_base::end);
                                                int fs=items.tellg();
                                                int nd=fs/sizeof(DebitCard);
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cards.read((char*)&C[i],sizeof(DebitCard));
                                                }
                                                cout<<"Enter Name:";
                                                cin>>cardName;
                                                cout<<"Enter Card No: ";
                                                cin>>cardNo;
                                                cout<<"Enter Phone No: ";
                                                cin>>no;
                                                cout<<"Enter CVV: ";
                                                cin>>Cvv;
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cout<<"Transacting From Your Debit Card.Please Wait...\n\n";
                                                        for(int i=0;i<50;i++)
                                                        {
                                                            cout<<loading;
                                                            delay(150);
                                                        }
                                                        cout<<"\n\nYou Purchased An Item Successfully.\n";
                                                        break;

                                                }
                                            }
                                            else
                                                {
                                                    break;
                                                }
                                        }
                                    }
                                }
                                items.close();
                                cout<<"Press Any Key.";
                                scanf("%*c");
                                getchar();
                            }
                            else if(type==3)
                            {
                                system("CLS");
                                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                items.open("Sensors.txt",ios::app);
                                cout<<"Size of Items Class: "<<sizeof(Items)<<endl;
                                items.seekg(0,ios_base::end);
                                filesize=items.tellg();
                                //cout<<"Size Of Actuators.txt: "<<filesize<<endl;
                                n=filesize/sizeof(Items);
                                cout<<"Number Of Items Present: "<<n<<endl;
                                items.close();
                                items.open("Sensors.txt",ios::in);
                                int j=0;
                                for(int i=0;i<n;i++)
                                {
                                    items.read((char*)&S[i],sizeof(Items));
                                    j++;
                                    S[i].displayItems();
                                }
                                if(j==0)
                                {
                                    cout<<"No Actuators Present.\n";
                                }
                                else
                                {
                                    cout<<"Enter The ID Of The Product You want To Buy: ";
                                    cin>>item_id;
                                    for(int i=0;i<n;i++)
                                    {
                                        if(item_id==S[i].id)
                                        {
                                            system("CLS");
                                            cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                                            cout<<"The Description Of the Product You Want To Buy: \n";
                                            S[i].displayItems();
                                            cout<<"Mode Of Payment: \n1 -> Debit Card.\n2 -> Credit Card.\n Enter your Choice: ";
                                            cin>>modeOfPayment;
                                            if(modeOfPayment==1)
                                            {
                                                cards.open("Debit.txt",ios::in);
                                                items.seekg(0,ios_base::end);
                                                int fs=items.tellg();
                                                int nd=fs/sizeof(DebitCard);
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cards.read((char*)&C[i],sizeof(DebitCard));
                                                }
                                                cout<<"Enter Name:";
                                                cin>>cardName;
                                                cout<<"Enter Card No: ";
                                                cin>>cardNo;
                                                cout<<"Enter Phone No: ";
                                                cin>>no;
                                                cout<<"Enter CVV: ";
                                                cin>>Cvv;
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cout<<"Transacting From Your Debit Card.Please Wait...\n";
                                                        for(int i=0;i<50;i++)
                                                        {
                                                            cout<<loading;
                                                            delay(150);
                                                        }
                                                        cout<<"\nYou Purchased An Item Successfully.\n";
                                                        break;

                                                }
                                            }
                                            else if(modeOfPayment==2)
                                            {
                                                cards.open("Credit.txt",ios::in);
                                                items.seekg(0,ios_base::end);
                                                int fs=items.tellg();
                                                int nd=fs/sizeof(DebitCard);
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cards.read((char*)&C[i],sizeof(DebitCard));
                                                }
                                                cout<<"Enter Name:";
                                                cin>>cardName;
                                                cout<<"Enter Card No: ";
                                                cin>>cardNo;
                                                cout<<"Enter Phone No: ";
                                                cin>>no;
                                                cout<<"Enter CVV: ";
                                                cin>>Cvv;
                                                for(int i=0;i<nd;i++)
                                                {
                                                    cout<<"Transacting From Your Debit Card.Please Wait...\n";
                                                        for(int i=0;i<50;i++)
                                                        {
                                                            cout<<loading;
                                                            delay(150);
                                                        }
                                                        cout<<"\nYou Purchased An Item Successfully.\n";
                                                        break;

                                                }
                                            }
                                            else
                                                {
                                                    break;
                                                }
                                        }
                                    }
                                }
                                items.close();
                                cout<<"Press Any Key.";
                                scanf("%*c");
                                getchar();
                            }
                        }
                        else if(ch5==4)
                        {
                            system("CLS");
                            cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                            it.readItem();
                            if(it.type==1)
                            {
                                items.open("Actuators.txt",ios::app);
                                items.write((char*)&it,sizeof(Actuators));
                                items.close();
                                cout<<"Your Item Added Successfully.";
                            }
                            else if(it.type==2)
                            {
                                items.open("Microcontrollers.txt",ios::app);
                                items.write((char*)&it,sizeof(Microcontrollers));
                                items.close();
                                cout<<"Your Item Added Successfully.";
                            }
                            else
                            {
                                items.open("Sensors.txt",ios::app);
                                items.write((char*)&it,sizeof(Sensors));
                                items.close();
                                cout<<"Your Item Added Successfully.";
                            }
                        }
                        else if(ch5==5)
                        {
                            Akshay.displayAdmin();
                            Gaurav.displayAdmin();
                            scanf("%*c");
                            getchar();
                        }
                        else if(ch5==6)
                        {
                            break;
                        }
                    }
                    }
                    else
                    {
                        cout<<"No Such User Existing.\n";
                        scanf("%*c");
                        getchar();
                    }
                }
                else if(ch4==3)
                {
                    break;
                }
                else
                {
                    cout<<"Invalid Entry.\n Please Try Again.";
                    delay(500);
                }
            }
            else if(ch1==3)
            {
                system("CLS");
                cout<<"\n\t\t\t\t\t     KLE TECH e-Mart.\n";
                cout<<"\n\n\n\t\t\t\t\t     Thank You.\n\t\t\t\t\t     Visit Again.Application Closing...\n\n";
                cout<<"\t\t\t\t\t";
                for(int i=0;i<50;i++)
                {
                    cout<<loading;
                    delay(150);
                }
                cout<<"\n\n\n\t\t\t\t\t     Application By \n\t\t\t\t\t     -> Akshaykumar Gunari\n\t\t\t\t\t     -> Gaurav J\n\t\t\t\t\t     KLE TECH";
                delay(500);
                break;
            }
            else
            {
                cout<<"Invalid Option.\nPease Try Again.";
                scanf("%*c");
                getchar();
                delay(100);
                break;
            }
        }
    }
    return 0;
}

