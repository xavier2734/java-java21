package java17.ex05;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 5 - java.util.function.Consumer
 */
public class Function_05_Test {

    //tag::functions[]
    // TODO compléter la fonction
    // TODO modifier le mot de passe en "secret"
    Consumer<Person> changePasswordToSecret = p -> p.setPassword("secret");

    // TODO compléter la fonction
    // TODO vérifier que l'age > 4 avec une assertion JUnit
    Consumer<Person> verifyAge = p -> {assert p.getAge() > 4;};

    // TODO compléter la fonction
    // TODO vérifier que le mot de passe est "secret" avec une assertion JUnit
    Consumer<Person> verifyPassword = p -> {assert p.getPassword().equals("secret");};
    //end::functions[]


    @Test
    public void test_consumer() throws Exception {
        List<Person> personList = Data.buildPersonList();

        // TODO invoquer la méthode personList.forEach pour modifier les mots de passe en "secret"
        // personList.forEach...
        personList.forEach(changePasswordToSecret);
        // TODO remplacer la boucle for par l'invocation de la méthode forEach
        // TODO Utiliser la méthode andThen pour chaîner les vérifications verifyAge et verifyPassword
        // personList.forEach...
        personList.forEach(verifyAge.andThen(verifyPassword));
    }
}

/**
 * Pour memoire
 * Function<T, R> -> 1 entrée -> 1 sortie
 * BiFunction<T, U, R> -> 2 entrées -> 1 sortie
 * BinaryOperator<T> -> 2 entrées du même type -> 1 sortie du même type
 *
 * A retenir :
 * predicate.test(objet) -> exécute le test.
 * predicate1.and(predicate2) -> les deux doivent être vrais.
 * predicate1.or(predicate2) -> au moins un doit être vrai.
 * predicate.negate() -> inverse le résultat (vrai devient faux, et inversement).
 *
 *Quelques interfaces :
 * Interface : Reçoit : Retourne : Utilisation
 * Predicate<T> : 1 objet : boolean : Tester une condition
 * Function<T,R> : 1 objet : une valeur : Transformer un objet
 * BinaryOperator<T> : 2 objets : 1 objet du même type : Combiner deux objets
 * Consumer<T> : 1 objet : rien (void) : Modifier ou effectuer une action
 */
