
#include <stdio.h>
#include <stdlib.h>

	
int nombre(int n){ // fonction nombre de type entier izay mandray 'entier n'
	int somme =0;
	//----------------------------
		for (int i=1 ; i<n+1 ; i++)
      {
          if ((n%i)==0)
				{
					somme=somme+i;					//mamoka ireo diviseurs
				}
      }
	//----------------------------
		if (somme == 2*n)
			{				//condition rehefa parfait ne nombre
				return 1;
	//-------------------------------
			}else if(somme < 2*n)
				{				// condition rehefa deficient
					return -1;
		//------------------------
				}else return 0; // sinon abandont izy izany
	
	}

int estbisextille(int annee){

	if((annee % 4 == 0 && annee %100 != 0) || (annee % 400 == 0) )
		{
			printf("l'annee est bisextille");
		}else
		{
		printf("l'annee n'est pas bisextille");
		}
	
	}
int main (){
	//exercice 3
	//1)
	int n =0; int nbr =0;
     	printf("entrer un entier n: ");
		scanf("%d",&n);

	nbr = nombre(n);

	printf("la nature est %d \n",nbr);

	int year =0; int isLeap=0;
	printf("entrer une année: ");
	scanf("%d",&year);

	isLeap = estbisextille(year);

	printf("%d \n",isLeap);

	return 0;
	}
