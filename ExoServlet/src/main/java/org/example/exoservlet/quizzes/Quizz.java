package org.example.exoservlet.quizzes;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/quizz")
public class Quizz {
    static List<Quiz> quizzes = new ArrayList<>();
    static List<List<Quiz>> listQuizzes = new ArrayList<>();
    static List<String> historiqueQuizzes = new ArrayList<>();
    //    static int count = 0;
    static int score = 0;
    static int scoreFinal =0;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<List<Quiz>> quizzes() {
        return listQuizzes;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String newQuiz(List<Quiz> question) {
        listQuizzes.add(question);
        return "Liste de question ajoutée.";
    }

//    @POST
//    @Produces("text/plain")
//    public String newQuiz(@QueryParam("question")String question, @QueryParam("reponse")String reponse) {
//        quizzes.add(new Quiz(count++, question,reponse));
//        return "Question ajoutée.";
//    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String quizz(@PathParam("id") int number) {
        if (listQuizzes.get(number).isEmpty()) {
            return "Quizz vide.";
        }
        quizzes = listQuizzes.get(number);
        return quizzes.toString();
    }

    @POST
    @Path("{id}/play")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String jouer(@PathParam("id") int number, Reponses reponses) {

        List<Quiz> quizzes = listQuizzes.get(number);
        System.out.println(quizzes);
        if (reponses.getR0().equals(quizzes.getFirst().getAnswer())) score++;
        if (reponses.getR1().equals(quizzes.get(1).getAnswer())) score++;
        if (reponses.getR2().equals(quizzes.get(2).getAnswer())) score++;
        if (reponses.getR3().equals(quizzes.get(3).getAnswer())) score++;
        if (reponses.getR4().equals(quizzes.get(4).getAnswer())) score++;
        if (reponses.getR5().equals(quizzes.get(5).getAnswer())) score++;
        if (reponses.getR6().equals(quizzes.get(6).getAnswer())) score++;
        if (reponses.getR7().equals(quizzes.get(7).getAnswer())) score++;
        if (reponses.getR8().equals(quizzes.get(8).getAnswer())) score++;
        if (reponses.getR9().equals(quizzes.getLast().getAnswer())) score++;
        scoreFinal = score;
        score = 0;
        String resultat = "Total de réponse correctes : " + scoreFinal;
        historiqueQuizzes.add(resultat);
        return resultat;
    }

    @GET
    @Path("{id}/results")
    @Produces(MediaType.TEXT_PLAIN)
    public String results(@PathParam("id") int number) {
        return "Réponse du quiz numéro " + number + "\n" + scoreFinal +"/10";
    }

    @GET
    @Path("{id}/history")
    @Produces(MediaType.TEXT_PLAIN)
    public String history(@PathParam("id") int number) {
        return "Réponse du quiz numéro " + number + "\n" + historiqueQuizzes;
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@PathParam("id") int number) {
        listQuizzes.remove(number);
        return "Question supprimée.";
    }
}
