

QueryProcessor is the gate API to this package, calls the other procedures.

SemanticGenerator implements queryBaseListener,
creates Stack, which has run(), which uses Interpret's callbacks to actually perform graph operations.