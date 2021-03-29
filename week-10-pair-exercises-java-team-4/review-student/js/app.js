let problem = {};
let answer;
let numCorrect = 0;
let problemNumber = 1;
let problemNumberContainer = document.querySelector('.currentProblem');
let numCorrectContainer = document.querySelector('.currentScore');

/**
 * Utility function to generate a random number based on max
 * @param {number} max
 */
 function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
  }

  /**
 * Utility function to shuffle the items in an array
 * @param {object} arr
 */
function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
  }

function startNewProblemSet() {
    generateAndDisplayProblem();
    }


function generateAndDisplayProblem() {
    let left = getRandomNumber(10);
    let right = getRandomNumber(10);
    answer = left*right;
    problem = {
        left: left,
        right: right,
        answer: answer
    };
    //display the problem
    const pContainer = document.getElementById('problem');
    const expression = `${problem.left} * ${problem.right}`;
    pContainer.querySelector('div.expression').innerText = expression;

    //generate the answers
    let answers = [problem.answer]; //start by adding the correct answer

    //get the number of answers based on how many spots we have
    const liAnswerArray = document.querySelectorAll('section#answers ul li');
    for (let i=0;i<liAnswerArray.length-1;i++) {//we already have one answer - the correct one
        answers.push(getRandomNumber(82)); //9*9=81
    }
    //sort the answers so the right answer isn't always first
    answers = shuffleArray(answers);

    //display the answers
    for (let i=0;i<liAnswerArray.length;i++){
        liAnswerArray[i].innerText = answers[i];
    }
}

    function increaseCurrentProblem(itemValue){
        
        if(answer == itemValue){
            numCorrect++;
            numCorrectContainer.innerText = numCorrect;
        }

        if (problemNumber<10){
            startNewProblemSet();
            problemNumber++;
            problemNumberContainer.innerText = problemNumber;}

          if (problemNumber == 10){
                let hidden = document.querySelectorAll('.show-hide');
                hidden.forEach( (element) => element.classList.add('hidden'));
                }

               

        }


document.addEventListener("DOMContentLoaded",() => {
    startNewProblemSet();

       const listItems = document.querySelector('ul');
       listItems.addEventListener('click', (event) => {
                let itemValue = event.target.innerText;
                increaseCurrentProblem(itemValue);
            })

        const startOver = document.getElementById('btnStartOver');
        startOver.addEventListener('click', (event) => {
         
            let exposed = document.querySelectorAll('.hidden');
            exposed.forEach( (element) => element.classList.remove('hidden'));

            startNewProblemSet();
            
            numCorrect = 0;
            problemNumber = 1;
            numCorrectContainer.innerText = numCorrect;
            problemNumberContainer.innerText = problemNumber;
                

        });

      
});

