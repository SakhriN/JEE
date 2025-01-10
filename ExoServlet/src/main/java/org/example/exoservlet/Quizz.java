package org.example.exoservlet;

import jakarta.ws.rs.*;

import java.util.ArrayList;
import java.util.List;

@Path("/quizz")
public class Quizz {
    static List<Quiz> quizzes = new ArrayList<>();
    static List<List<Quiz>> listQuizzes = new ArrayList<>();
    static int count = 0;


    @GET
    @Produces("application/json")
    public List<Quiz> quizzes() {
        return quizzes;
    }

    @POST
    @Produces("text/plain")
    public String newQuiz(@QueryParam("question")String question, @QueryParam("reponse")String reponse) {
        quizzes.add(new Quiz(count++, question,reponse));
        return "Question ajoutée.";
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public String quizz(@PathParam("id") int number) {
        if (quizzes.isEmpty()) {
            return "Quizz vide.";
        }else{
        return quizzes.get(number).getQuestion();
        }
    }

    @POST
    @Path("{id}/play")
    @Produces("text/plain")
    public String jouer(@PathParam("id") int number,@QueryParam("reponse")String reponse) {
        Quiz quiz = quizzes.get(number);
        if(reponse.equals(quiz.getAnswer())){
            return "Bonne réponse.";
        }else{
        return "Mauvaise réponse. La réponse était "+ quiz.getAnswer();
        }
    }

    @GET
    @Path("{id}/results")
    @Produces("text/plain")
    public String results(@PathParam("id") int number) {
        return number+"bravo";
    }


    @GET
    @Path("{id}/history")
    @Produces("text/plain")
    public String history(@PathParam("id") int number) {
        return "Hello, World!";
    }


    @DELETE
    @Path("{id}")
    @Produces("text/plain")
    public String delete(@PathParam("id")int number) {
        quizzes.remove(quizzes.get(number));
        return "Question supprimée.";
    }

}
