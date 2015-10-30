package es.dgoj.rgiaj.business.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCarta is a Querydsl query type for Carta
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCarta extends EntityPathBase<Carta> {

    private static final long serialVersionUID = 884849487;

    public static final QCarta carta = new QCarta("carta");

    public final NumberPath<Long> cargo = createNumber("cargo", Long.class);

    public final StringPath descripcion = createString("descripcion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath pie = createString("pie");

    public final NumberPath<Long> responsable = createNumber("responsable", Long.class);

    public final StringPath texto = createString("texto");

    public QCarta(String variable) {
        super(Carta.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QCarta(Path<? extends Carta> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QCarta(PathMetadata<?> metadata) {
        super(Carta.class, metadata);
    }

}

